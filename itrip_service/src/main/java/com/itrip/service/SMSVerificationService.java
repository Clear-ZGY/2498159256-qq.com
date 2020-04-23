package com.itrip.service;

import com.itrip.dto.Dto;

public interface SMSVerificationService {
    /**
     * 发送验证短信
     */
    Boolean sendSMSVerification(String mobileNumber,String msgCode);

    /**
     * 验证 短信验证码
     */
    Boolean verifyReceiptCode(String mobileNumber,String code);
}
