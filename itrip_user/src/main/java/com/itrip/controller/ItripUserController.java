package com.itrip.controller;

import com.alibaba.fastjson.JSONObject;
import com.itrip.dto.Dto;
import com.itrip.entity.ItripUser;
import com.itrip.exception.TokenValidationFailedException;
import com.itrip.service.ItripUserService;
import com.itrip.service.RedisAPIService;
import com.itrip.service.SMSVerificationService;
import com.itrip.service.TokenService;
import com.itrip.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Objects;

/**
 * 用户表(ItripUser)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("/api")
@Api(value = "API")
public class ItripUserController {
    /**
     * 服务对象
     */
    @Resource
    private ItripUserService itripUserService;
    @Resource
    private RedisAPIService redisAPIService;
    @Resource
    private TokenService tokenService;
    @Resource
    private SMSVerificationService smsVerificationService;
    @Resource
    private SMSVerificationUtil smsVerificationUtil;

    /**
     * 用户登录
     *
     * @param name     用户名
     * @param password 密码
     * @return 单条数据
     */
    @RequestMapping(value = "dologin", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录（/api/dologin）", notes = "用户登录", httpMethod = "POST")
    @ResponseBody
    public Dto dologin(String name, String password, HttpServletRequest request) {
        //System.err.println(user.getUsername());
        ItripUser itripUser = this.itripUserService.queryByUserName(name);
        String token = "";
        if (null != itripUser) {
            if (itripUser.getUserpassword().equals(password)) {
                //获取用户代理信息
                String userAgent = request.getHeader("user-agent");
                //存入token
                token = tokenService.getToken(userAgent, itripUser);
                //存入Redis
                boolean result = redisAPIService.set(token, ClientCode.CACHE_EXPIRATION_TIME, JSONObject.toJSONString(itripUser));
                if (result == true) {
                    return DtoUtil.returnSuccess(token);
                } else {
                    return DtoUtil.returnFail("创建token失败", ErrorCode.AUTH_CREATE_FAILED);
                }
            } else {
                return DtoUtil.returnFail("密码错误", ErrorCode.USER_PWD_ERR);
            }
        } else {
            return DtoUtil.returnFail("用户名错误", ErrorCode.AUTH_ILLEGAL_USERCODE);
        }
    }

    /**
     * 用户注销
     * <p>
     * token: 用户token
     *
     * @return 删除结果
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ApiOperation(value = "用户注销（/api/logout）", notes = "用户注销 ", httpMethod = "GET")
    @ResponseBody
    public Dto logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        boolean exist = redisAPIService.exist(token);
        if (exist == true) {
            redisAPIService.delete(token);
            return DtoUtil.returnSuccess(token);
        } else {
            return DtoUtil.returnFail("token无效", ErrorCode.AUTH_TOKEN_INVALID);
        }
    }

    /**
     * 客户端置换token
     * <p>
     * token: 用户token
     */
    @RequestMapping(value = "retoken", method = RequestMethod.POST)
    @ApiOperation(value = "客户端置换token（/api/retoken）", notes = "客户端置换token ", httpMethod = "POST")
    @ResponseBody
    public Dto retoken(HttpServletRequest request) {
        //获取用户代理信息
        String userAgent = request.getHeader("user-agent");
        String token = request.getHeader("token");
        if (redisAPIService.exist(token)) {
            String newToken = "";
            try {
                newToken = tokenService.replaceToken(userAgent, token);
            } catch (TokenValidationFailedException e) {
                e.printStackTrace();
                return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_REPLACEMENT_FAILED);
            }
            return DtoUtil.returnSuccess(newToken);
        } else {
            return DtoUtil.returnFail("token无效", ErrorCode.AUTH_TOKEN_INVALID);
        }
    }

    @RequestMapping(value = "registerbyphone", method = RequestMethod.POST)
    @ApiOperation(value = "手机注册（/api/registerbyphone）", notes = "手机注册 ", httpMethod = "POST")
    @ResponseBody
    public Dto registerbyphone(@RequestBody ItripUser userVO) {
        System.err.println(userVO.getUsercode());
        if (userVO != null && !Objects.equals(userVO, "")) {
            boolean result = ThirdPartyLoginUtil.validateMobileNumber(userVO.getUsercode());
            if (result == true) {
                ItripUser user = itripUserService.queryByUserCode(userVO.getUsercode());
                if (user == null) {
                    ItripUser itripUser = new ItripUser();
                    itripUser.setUsercode(userVO.getUsercode());
                    itripUser.setUserpassword(userVO.getUserpassword());
                    itripUser.setUsertype(0);
                    itripUser.setCreationdate(new Date());
                    itripUser.setUsername(userVO.getUsername());
                    ItripUser insert = itripUserService.insert(itripUser);
                    int randomCode = MD5.getRandomCode();
                    String msgCode = String.valueOf(randomCode);
                    if (insert != null && !Objects.equals(insert, "")) {
                        Boolean resultSMS = smsVerificationService.sendSMSVerification(userVO.getUsercode(), msgCode);//发送信息验证码
                        if (resultSMS) {
                            boolean set = redisAPIService.set("code:" + userVO.getUsercode(), ClientCode.SMS_VALIDATION_EXPIRATION_TIME, String.valueOf(randomCode));
                            if (set == true) {
                                return DtoUtil.returnSuccess();
                            } else {
                                return DtoUtil.returnFail("创建Token失败", ErrorCode.AUTH_CREATE_FAILED);
                            }
                        } else {
                            return DtoUtil.returnFail("短信验证码发送失败", ErrorCode.SMS_VERIFICATION_CODE_SENDING_FAILED);
                        }
                    } else {
                        return DtoUtil.returnFail("创建账户失败", ErrorCode.AUTH_USER_CREATE_FAILED);
                    }

                } else {
                    return DtoUtil.returnFail("用户已存在", ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }

            } else {
                return DtoUtil.returnFail("手机号码格式不正确或为空", ErrorCode.THE_PHONE_NUMBER_FORMAT_IS_INCORRECT_OR_EMPTY);
            }

        } else {
            return DtoUtil.returnFail("用户为空，非法用户账号！", ErrorCode.USER_ILLEGAL_CODE_ERR);
        }
    }

    @RequestMapping(value = "validatephone", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "手机注册短信验证（/api/registerbyphone）", notes = "手机注册短信验证 ", httpMethod = "PUT")
    @ResponseBody
    public Dto validatephone(@ApiParam(name = "user", value = "手机号码", defaultValue = "13811565189") @RequestParam(value = "user", required = false, defaultValue = "13811565189") String user,
                             @ApiParam(name = "code", value = "验证码", defaultValue = "8888") @RequestParam(value = "code", required = false, defaultValue = "8888") String code) {
        System.out.println("user:::" + user);
        System.out.println("code:::" + code);
        return smsVerificationService.verifyReceiptCode(user,code);
    }

    /*@RequestMapping(value = "getcode", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "手机注册（/api/getcode）", notes = "手机注册 ", httpMethod = "POST")
    @ResponseBody
    public Dto getCode(@ApiParam(name = "mobileNumber", value = "手机号码", defaultValue = "13811565189") @RequestParam(value = "mobileNumber", required = false, defaultValue = "13811565189") String mobileNumber) {
        System.out.println("mobileNumber:::" + mobileNumber);
        int randomCode = MD5.getRandomCode();
        Boolean result = smsVerificationUtil.sendCode(mobileNumber, String.valueOf(randomCode));
        if (result) {
            boolean set = redisAPIService.set("code:" + mobileNumber, ClientCode.SMS_VALIDATION_EXPIRATION_TIME, String.valueOf(randomCode));
            if (set == true) {
                return DtoUtil.returnSuccess();
            } else {
                return DtoUtil.returnFail("创建Token失败", ErrorCode.AUTH_CREATE_FAILED);
            }
        } else {
            return DtoUtil.returnFail("短信验证码发送失败", ErrorCode.SMS_VERIFICATION_CODE_SENDING_FAILED);
        }
    }
*/
}