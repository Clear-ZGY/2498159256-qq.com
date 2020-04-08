package com.itrip.controller;


import com.alibaba.fastjson.JSONObject;
import com.itrip.dto.Dto;
import com.itrip.entity.ItripUser;
import com.itrip.service.ItripUserService;
import com.itrip.service.RedisAPIService;
import com.itrip.service.TokenService;
import com.itrip.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * 第三方接入控制层(VendorsController)
 *
 * @author zgy
 * @since 2020-4-8 16:12:17
 */
@RestController
@RequestMapping("/vendors")
@Api(value = "API")
public class VendorsController {

    @Resource
    private ItripUserService itripUserService;
    @Resource
    private RedisAPIService redisAPIService;
    @Resource
    private TokenService tokenService;

    /**
     * 第三方登录：获取code
     *
     * @param response
     */
    @GetMapping(value = "weibo/getcode")
    @ApiOperation(value = "第三方接入获取code（/vendors/weibo/getcode）", notes = "第三方接入获取code", httpMethod = "POST")
    public void weiboGetCode(HttpServletResponse response) {
        String callbackUrl = "http://127.0.0.1:8080/itrip/vendors/weibo/callback";
        String encodeUrl = "";
        try {
            encodeUrl = URLEncoder.encode(callbackUrl, "UTF-8");
            System.out.println("getcode：：：" + encodeUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /*
        https://api.weibo.com/oauth2/authorize?client_id=2482047288&redirect_uri=http%3A%2F%2F127.0.0.1%3A8080%2Fitrip%2Fapi%2Fback
        **/
        String authUrl = "https://api.weibo.com/oauth2/authorize" +
                "?client_id=2482047288" +
                "&redirect_uri=" + encodeUrl;
        try {
            response.sendRedirect(authUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第三方登录：获取token并保存
     * @param code 第三方返回code
     * @param request
     * @return
     */
    @GetMapping(value = "weibo/callback")
    @ApiOperation(value = "第三方接入回调函数（/vendors/weibo/callback）", notes = "第三方接入回调函数", httpMethod = "POST")
    public Dto weiboCallBack(String code, HttpServletRequest request) {
        System.out.println("code：：：" + code);
        String backUrl = "http://127.0.0.1:8080/itrip/vendors/weibo/callback";
        String encodeUrl = "";
        try {
            encodeUrl = URLEncoder.encode(backUrl, "UTF-8");
            System.out.println("callback：：：" + encodeUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //URL转码异常时，返回错误信息
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.URL_PARSE_ERR);
        }
        String geAccessTokenUrl = "https://api.weibo.com/oauth2/access_token" +
                "?client_id=2482047288" +
                "&client_secret=542045a8e99aae5a8897eadcd53f86ee" +
                "&grant_type=authorization_code" +
                "&redirect_uri=" + encodeUrl +
                "&code=" + code;
        //换取Access Token，得到json字符串
        String result = UrlUtils.loadURL(geAccessTokenUrl);
        System.out.println("返回结果：：：" + result);
        if (null != result && !("").equals(result)) {
            try {
                //将获取到的json字符串转换为Map集合
                Map<String, Object> map = JSONObject.parseObject(result, Map.class);
                //map集合应包含的键[Map:{access_token,remind_in,expires_in,uid,isRealName}]
                String access_token = map.get("access_token").toString();
                String uid = map.get("uid").toString();
                ItripUser itripUser = itripUserService.queryByUserCode(uid);
                //若是第三方登录，系统将自动生成唯一账号；若无此账号，将创建一个新账户
                if (null == itripUser) {
                    itripUser = new ItripUser();
                    itripUser.setUsercode(uid);
                    //将UID的后六位设置为密码
                    String passWord = ThirdPartyLoginUtil.creatPassWord(uid);
                    itripUser.setUserpassword(passWord);
                    itripUser.setUsertype(3);
                    itripUser.setUsername(uid);
                    itripUser.setCreationdate(new Date());
                    itripUser.setActivated(1);
                    ItripUser insert = itripUserService.insert(itripUser);
                    if (null == insert) {
                        return DtoUtil.returnFail("用户创建失败", ErrorCode.AUTH_USER_CREATE_FAILED);
                    }
                }
                //获取用户代理信息
                String userAgent = request.getHeader("user-agent");
                String tokenThirdParty = tokenService.getTokenThirdParty(userAgent, access_token);
                boolean flag = redisAPIService.set(tokenThirdParty, ClientCode.CACHE_EXPIRATION_TIME, JSONObject.toJSONString(itripUser));
                if (flag == true) {
                    return DtoUtil.returnSuccess(tokenThirdParty);
                } else {
                    return DtoUtil.returnFail("创建token失败", ErrorCode.AUTH_CREATE_FAILED);
                }
            } catch (Exception e) {
                return DtoUtil.returnFail(e.getMessage(), ErrorCode.USER_ILLEGAL_CODE_ERR);
            }
        } else {
            return DtoUtil.returnFail("换取AccessToken失败", ErrorCode.AUTH_REPLACETOKEN_FAILED);
        }
    }

}
