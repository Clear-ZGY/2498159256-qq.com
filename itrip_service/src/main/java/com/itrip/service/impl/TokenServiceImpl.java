package com.itrip.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrip.exception.TokenValidationFailedException;
import com.itrip.service.RedisAPIService;
import com.itrip.utils.ClientCode;
import com.itrip.utils.MD5;
import com.itrip.utils.RedisAPI;
import com.itrip.utils.UserAgentUtil;
import com.itrip.entity.ItripUser;
import com.itrip.service.TokenService;
import cz.mallat.uasparser.UserAgentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RedisAPIService redisAPIService;

    /**
     * 创建token
     *
     * @param agent     用户设备信息
     * @param itripUser 实体类
     * @return
     */
    @Override
    public String getToken(String agent, ItripUser itripUser) {
        StringBuffer sb = new StringBuffer();
        UserAgentInfo userAgentInfo = null;
        try {
            userAgentInfo = UserAgentUtil.getUasParser().parse(agent);
            if (userAgentInfo.getDeviceType().equals(UserAgentInfo.UNKNOWN)) {
                if (UserAgentUtil.CheckAgent(agent)) {
                    sb.append("MOBILE-");
                } else {
                    sb.append("PC-");
                }
            } else if (userAgentInfo.getDeviceType()
                    .equals("Personal computer")) {
                sb.append("PC-");
            } else {
                sb.append("MOBILE-");
            }

            sb.append("user:token:");
            sb.append(MD5.getMd5(itripUser.getUsername(), 6));
            sb.append(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
            /*sb.append(System.currentTimeMillis());*/
            sb.append(MD5.getMd5(String.valueOf(MD5.getRandomCode()), 6));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 创建token
     *
     * @param agent     用户设备信息
     * @param access_token 第三方token
     * @return
     */
    @Override
    public String getTokenThirdParty(String agent, String access_token) {
        StringBuffer sb = new StringBuffer();
        UserAgentInfo userAgentInfo = null;
        try {
            userAgentInfo = UserAgentUtil.getUasParser().parse(agent);
            if (userAgentInfo.getDeviceType().equals(UserAgentInfo.UNKNOWN)) {
                if (UserAgentUtil.CheckAgent(agent)) {
                    sb.append("MOBILE-");
                } else {
                    sb.append("PC-");
                }
            } else if (userAgentInfo.getDeviceType()
                    .equals("Personal computer")) {
                sb.append("PC-");
            } else {
                sb.append("MOBILE-");
            }

            sb.append("user:token:");
            sb.append(access_token);
            /*sb.append(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
            sb.append(MD5.getMd5(String.valueOf(MD5.getRandomCode()), 6));*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 置换token
     *
     * @param agent 用户设备信息
     * @param token 需要置换的token
     * @return
     */
    @Override
    public String replaceToken(String agent, String token) throws TokenValidationFailedException {
        String newToken = "";
        if (redisAPIService.exist(token)) {
            String result = redisAPIService.get(token);
            //将token的值转换为实体类
            ItripUser itripUser = json2Obj(result);
            if (redisAPIService.ttl(token) > 0 || redisAPIService.ttl(token) == -1) {
                //生成新token
                newToken = this.getToken(agent, itripUser);
                //存入Redis
                redisAPIService.set(newToken,ClientCode.CACHE_EXPIRATION_TIME,JSONObject.toJSONString(itripUser));
                //将旧token设置为5秒后失效
                redisAPIService.set(token,5,JSONObject.toJSONString(itripUser));
            }else {
                //token失效时，抛出此异常，终止置换
                throw new TokenValidationFailedException("token已过期");
            }
        }else{
            //无此token时，抛出此异常，终止置换
            throw new TokenValidationFailedException("未知的token或者token已过期");
        }
        return newToken;
    }

    /**
     * 将json字符串转换为实体类对象
     *
     * @param json
     * @return
     */
    public static ItripUser json2Obj(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ItripUser itripUser = mapper.readValue(json, ItripUser.class);
            return itripUser;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
