package com.itrip.utils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirdPartyLoginUtil {
    /**
     * 第三方登录时，自动创建密码为UID的后六位
     */
    public static String creatPassWord(String uid) {
        int length = uid.length();
        if (length < 6) {
            StringBuffer password = new StringBuffer(uid);
            int count = 6 - length;
            for (int i = 0; i < count; i++) {
                password.append(1);
            }
            return password.toString();
        } else {
            String password = uid.substring(length - 6, length);
            return password;
        }
    }

    public static boolean validateMobileNumber(String mobileNumber) {
        boolean flag = false;
        if (mobileNumber != null && !Objects.equals(mobileNumber, "")) {
            String telRegex = "^[1][3,4,5,7,8][0-9]{9}$";//以1开始，第二位为3,4,5,7,8 中任意一位，共11位
            Pattern pattern = Pattern.compile(telRegex);
            Matcher matcher = pattern.matcher(mobileNumber);
            flag = matcher.matches();
        }
        return flag;
    }
}
