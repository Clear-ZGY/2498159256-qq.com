package com.itrip.service;

public interface EmailVerificationService {
    /**
     * 邮箱发送验证码
     * @param receivingAddress 接受验证码的邮箱地址
     * @param emailCode 验证码
     * @return
     */
    Boolean sendEmail(String receivingAddress,String emailCode);

    /**
     * 邮箱验证
     * @param emailAddress 邮箱地址
     * @param emailCode 验证码
     * @return
     */
    Boolean verificationEmailCode(String emailAddress,String emailCode);
}
