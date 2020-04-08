package com.itrip.service;


import com.itrip.entity.ItripUser;
import com.itrip.exception.TokenValidationFailedException;

public interface TokenService {

    // token -> 用户JSON
    // 创建token，存入redis

    /**
     * 创建token
     * @param agent 用户设备信息
     * @param itripUser 实体类
     * @return
     */
    String getToken(String agent, ItripUser itripUser);

    /**
     * 创建token
     * @param agent 用户设备信息
     * @param access_token 第三方token
     * @return
     */
    String getTokenThirdParty(String agent, String access_token);

    /**
     * 置换token
     * @param agent 用户设备信息
     * @param token 需要置换的token
     * @return
     */
    String replaceToken(String agent, String token) throws TokenValidationFailedException;
}
