package com.itrip.service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.itrip.dto.Dto;
import com.itrip.entity.ItripUser;
import com.itrip.service.ItripUserService;
import com.itrip.service.RedisAPIService;
import com.itrip.service.SMSVerificationService;
import com.itrip.utils.ClientCode;
import com.itrip.utils.DtoUtil;
import com.itrip.utils.ErrorCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

@Service("smsVerificationService")
public class SMSVerificationServiceImpl implements SMSVerificationService {
    @Resource
    private RedisAPIService redisAPIService;
    @Resource
    private ItripUserService itripUserService;





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
    @Override
    public Boolean sendSMSVerification(String mobileNumber,String msgCode){
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



    /*@Override
    public Dto sendSMSVerification(String mobileNumber) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8a216da87172b2ee01717c8d49130500";
        String accountToken = "16eeaa3684f04eb9a1b6b1ea3e9d91f6";
        //请使用管理控制台中已创建应用的APPID
        String appId = "8a216da87172b2ee01717c8d49790507";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        //前端传入的电话号码
        String to = mobileNumber;
        String templateId = "1";
        String msgCode = String.format("%06d", new Random().nextInt(999999));
        String[] datas = {msgCode, "15"};
        HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
            //信息发送正常，将电话号码作为key，把验证码存入redis
            boolean resultSet = redisAPIService.set(mobileNumber, ClientCode.SMS_VALIDATION_EXPIRATION_TIME, msgCode);
            if (resultSet != true) {
                return DtoUtil.returnFail("创建Token失败", ErrorCode.AUTH_CREATE_FAILED);
            } else {
                return DtoUtil.returnSuccess();
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            return DtoUtil.returnFail(result.get("statusMsg") + "", result.get("statusCode") + "");
        }
    }*/

    /**
     * 验证 短信验证码
     *
     * @param mobileNumber 电话号码
     * @param code         回执码
     */
    @Override
    public Dto verifyReceiptCode(String mobileNumber, String code) {
        String key="code:" +mobileNumber;
        if (redisAPIService.exist(key) == true) {
            String result = redisAPIService.get(key);
                if (result.equals(code)) {
                    ItripUser itripUser = itripUserService.queryByUserCode(mobileNumber);
                    if(itripUser!=null){
                        itripUser.setActivated(1);//激活用户
                        itripUser.setFlatid(itripUser.getId());
                        ItripUser update = itripUserService.update(itripUser);
                        redisAPIService.set(key,5,code);
                        return DtoUtil.returnSuccess();
                    }else{
                        return DtoUtil.returnFail("用户不存在，非法用户账号",ErrorCode.USER_ILLEGAL_CODE_ERR);
                    }
                } else {
                    return DtoUtil.returnFail("短信验证码不匹配", ErrorCode.SMS_VERIFICATION_CODE_MISMATCH);
                }
        }else {
            return DtoUtil.returnFail("手机号码不存在或已失效", ErrorCode.MOBILE_NUMBER_DOES_NOT_EXIST_OR_IS_INVALID);
        }

    }
}
