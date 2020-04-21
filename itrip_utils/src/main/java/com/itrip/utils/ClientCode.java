package com.itrip.utils;

public class ClientCode {
    /**
     * 用户token过期时间：2小时
     */
    public static final Integer CACHE_EXPIRATION_TIME = 60 * 60 * 2;
    /**
     * 用户短信验证在Redis中过期时间：15分钟
     * Redis中过期时间以毫秒为单位
     */
    public static final Integer SMS_VALIDATION_EXPIRATION_TIME = 60 * 15;
    /**
     * 用户短信验证过期时间：15分钟
     */
    public static final Integer SMS_VALIDATION_EXPIRATION_TIME_BY_CLIENT = 15;

}
