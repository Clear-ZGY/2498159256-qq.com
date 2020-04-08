package com.itrip.utils;

public class ThirdPartyLoginUtil {
    /**
     * 第三方登录时，自动创建密码为UID的后六位
     */
    public static String creatPassWord(String uid) {
        int length = uid.length();
        if (length < 6) {
            StringBuffer password= new StringBuffer(uid);
            int count=6-length;
            for (int i = 0; i <count ; i++) {
                password.append(1);
            }
            return password.toString();
        }else{
            String password = uid.substring(length - 6, length);
            return password;
        }
    }
}
