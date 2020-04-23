package com.itrip.service.impl;

import com.itrip.entity.ItripUser;
import com.itrip.service.EmailVerificationService;
import com.itrip.service.ItripUserService;
import com.itrip.service.RedisAPIService;
import com.itrip.utils.ClientCode;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Resource
    private SimpleMailMessage activationMailMessage;
    @Resource
    private MailSender mailSender;
    @Resource
    private ItripUserService itripUserService;
    @Resource
    private RedisAPIService redisAPIService;

    /**
     * 邮箱发送验证码
     * @param receivingAddress 接受验证码的邮箱地址
     * @param emailCode 验证码
     * @return
     */
    @Override
    public Boolean sendEmail(String receivingAddress, String emailCode) {
        try {
            activationMailMessage.setTo(receivingAddress); // 接收邮件的地址
            activationMailMessage.setText("北大青鸟【i旅行】邮箱注册码：" + emailCode+",请在"+ ClientCode.SMS_VALIDATION_EXPIRATION_TIME_BY_CLIENT+"分钟内完成验证。"); // 发送的消息
            activationMailMessage.setSubject("【i旅行】请激活您的账户");
            mailSender.send(activationMailMessage);//发送信息验证码
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 邮箱验证
     *
     * @param emailAddress 邮箱地址
     * @param emailCode    验证码
     * @return
     */
    @Override
    public Boolean verificationEmailCode(String emailAddress, String emailCode) {
        String key="code:" +emailAddress;
        if (redisAPIService.exist(key) == true) {
            String result = redisAPIService.get(key);
            if (result.equals(emailCode)) {
                ItripUser itripUser = itripUserService.queryByUserCode(emailAddress);
                if(itripUser!=null){
                    itripUser.setActivated(1);//激活用户
                    itripUser.setFlatid(itripUser.getId());
                    ItripUser update = itripUserService.update(itripUser);
                    redisAPIService.set(key,5,emailCode);
                    //return DtoUtil.returnSuccess();
                    return true;
                }else{
                    //return DtoUtil.returnFail("用户不存在，非法用户账号",ErrorCode.USER_ILLEGAL_CODE_ERR);
                    return false;
                }
            } else {
                //return DtoUtil.returnFail("短信验证码不匹配", ErrorCode.SMS_VERIFICATION_CODE_MISMATCH);
                return false;
            }
        }else {
            //return DtoUtil.returnFail("手机号码不存在或已失效", ErrorCode.MOBILE_NUMBER_DOES_NOT_EXIST_OR_IS_INVALID);
            return false;
        }
    }
}
