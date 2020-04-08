package com.itrip.controller;

import com.alibaba.fastjson.JSONObject;
import com.itrip.dto.Dto;
import com.itrip.entity.ItripUser;
import com.itrip.exception.TokenValidationFailedException;
import com.itrip.service.ItripUserService;
import com.itrip.service.RedisAPIService;
import com.itrip.service.TokenService;
import com.itrip.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    /**
     * 用户第三方登录回调
     * https://api.weibo.com/oauth2/authorize?client_id=2482047288&redirect_uri=http%3A%2F%2F127.0.0.1%3A8080%2Fitrip%2Fapi%2Fback
     *//*
    @RequestMapping(value = "back", method = RequestMethod.GET)
    @ApiOperation(value = "用户第三方登录回调（/api/back）", notes = "用户第三方登录回调 ", httpMethod = "GET")
    @ResponseBody
    public Dto back(String code) {
        String backUrl = "http://127.0.0.1:8080/itrip/api/back";
        String encode = "";
        try {
            encode = URLEncoder.encode(backUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.URL_PARSE_ERR);
        }
        System.out.println("回调成功：：：" + code);
        String url = "https://api.weibo.com/oauth2/access_token" +
                "?client_id=2482047288" +
                "&client_secret=542045a8e99aae5a8897eadcd53f86ee" +
                "&grant_type=authorization_code" +
                "&redirect_uri=" + encode +
                "&code=" + code;
        String result = UrlUtils.loadURL(url);
        System.out.println("返回结果：：：" + result);
        return DtoUtil.returnSuccess(result);
    }*/
}