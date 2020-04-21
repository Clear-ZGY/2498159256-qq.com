package com.itrip.utils;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.itrip.dto.Dto;
import com.itrip.entity.ItripUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

@Component
public class SMSVerificationUtil {

    //生产环境请求地址：app.cloopen.com
    private final String SERVERIP = "app.cloopen.com";
    //请求端口
    private final String SERVERPORT = "8883";
    //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
    private final String ACCOUNTSID = "8a216da87172b2ee01717c8d49130500";
    private final String ACCOUNTSTOKEN = "16eeaa3684f04eb9a1b6b1ea3e9d91f6";
    //请使用管理控制台中已创建应用的APPID
    private final String APPID = "8a216da87172b2ee01717c8d49790507";

    /**
     * 发送验证短信
     *
     * @param mobileNumber 电话号码
     */
    public Boolean sendCode(String mobileNumber,String msgCode){
        //模板
        String templateId = "1";
        //随机6位验证码
        //String msgCode = String.format("%06d", new Random().nextInt(999999));

        String[] datas = {msgCode, String.valueOf(ClientCode.SMS_VALIDATION_EXPIRATION_TIME_BY_CLIENT)};
        return sendMessage(mobileNumber,templateId,datas);
    }


    private Boolean sendMessage(String mobileNumber, String templateId, String[] datas) {
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(SERVERIP, SERVERPORT);
        sdk.setAccount(ACCOUNTSID, ACCOUNTSTOKEN);
        sdk.setAppId(APPID);
        sdk.setBodyType(BodyType.Type_JSON);

        HashMap<String, Object> result = sdk.sendTemplateSMS(mobileNumber, templateId, datas);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
            return true;
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            return false;
        }
    }

}
