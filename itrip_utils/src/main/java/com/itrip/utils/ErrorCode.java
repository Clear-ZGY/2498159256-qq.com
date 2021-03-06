package com.itrip.utils;

/**
 * 系统错误编码，根据业务定义如下
 * <br/>
 * 酒店主业务biz：1开头（10000）<br/>
 * 评论：10001 ——10100<br/>
 * 酒店详情：10101 ——10200<br/>
 * 订单：10201 ——10400<br/>
 * 搜索search：2开头（20000）<br/>
 * 认证auth：3开头（30000）<br/>
 * 支付trade：4开头（40000）<br/>
 * 第三方接入：5开头 （50000）
 *
 * @author hduser
 */
public class ErrorCode {

    /*认证模块错误码-start*/
    public final static String AUTH_UNKNOWN = "30000";
    public final static String AUTH_USER_ALREADY_EXISTS = "30001";//用户已存在
    public final static String AUTH_AUTHENTICATION_FAILED = "30002";//认证失败
    public final static String AUTH_PARAMETER_ERROR = "30003";//用户名密码参数错误，为空
    public final static String AUTH_ACTIVATE_FAILED = "30004";//邮件注册，激活失败
    public final static String AUTH_REPLACEMENT_FAILED = "30005";//置换token失败
    public final static String AUTH_TOKEN_INVALID = "30006";//token无效
    public static final String AUTH_ILLEGAL_USERCODE = "30007";//非法的用户名
    public static final String USER_PWD_ERR = "30008";  // 密码错误
    public static final String USER_ILLEGAL_CODE_ERR = "30009";  // 非法用户账号
    public final static String AUTH_USER_CREATE_FAILED = "30010";//用户创建失败
    public final static String AUTH_CREATE_FAILED = "30011";//创建token失败
    public final static String SMS_VERIFICATION_CODE_MISMATCH = "30012";//短信验证码不匹配
    public final static String MOBILE_NUMBER_DOES_NOT_EXIST_OR_IS_INVALID = "30013";//手机号码不存在或已失效
    public final static String THE_PHONE_NUMBER_FORMAT_IS_INCORRECT_OR_EMPTY = "30014";//手机号码格式不正确或为空
    public final static String SMS_VERIFICATION_CODE_SENDING_FAILED = "30015";//短信验证码发送失败
    public final static String SMS_VERIFICATION_FAILED = "30018";//短信验证失败

    public final static String THE_EMAIL_ACCOUNT_FORMAT_IS_INCORRECT_OR_EMPTY = "30016";//邮箱账号格式不正确或为空
    public final static String EMAIL_VERIFICATION_CODE_SENDING_FAILED = "30017";//邮箱验证码发送失败


    /*认证模块错误码-end*/

    /*第三方接入错误码-start*/
    public static final String URL_PARSE_ERR = "5000";  // 密码错误
    public static final String AUTH_REPLACETOKEN_FAILED = "5001";  // 换取AccessToken失败

    /*第三方接入错误码-end*/

    /*酒店主业务biz-start*/
    public static final String PARAMETER_IS_NULL = "10203";//(cityId)参数为空
    public static final String PARAMETER_IS_NULL_QUERYBUTYPE = "10201 ";//( hotelId)参数为空
    public static final String SYSTEM_EXCEPTION_GET_FAILED_QUERYBUTYPE = "10202  ";//( hotelId)参数为空
    public static final String SYSTEM_EXCEPTION_GET_FAILED = "10204 ";//系统异常获取失败
    public static final String SYSTEM_EXCEPTION_GET_FAILED_QUERYBYPOLICY  = "10209 ";//系统异常获取失败
    public static final String SYSTEM_EXCEPTION_GET_FAILED_QUERYBYPARENTID = "10205   ";//系统异常获取失败
    public static final String SYSTEM_EXCEPTION_GET_FAILED_GETHOTELDESC = "10211   ";//系统异常获取失败
    public static final String SYSTEM_EXCEPTION_GET_FAILED_QUERYHOTELFACILITIES = "10207 ";//系统异常获取失败
    public static final String FAILED_TO_GET_HOTEL_VIDEO_TEXT_DESCRIPTION = "100214  ";//系统异常获取失败
    public static final String HOTEL_ID_IS_EMPTY = "100213  ";//酒店ID为空
    public static final String HOTEL_ID_IS_EMPTY_QUERYHOTELFACILITIES = "10206  ";//酒店ID为空
    public static final String HOTEL_ID_IS_EMPTY_QUERYBYPOLICY = "10208  ";//酒店ID为空
    public static final String HOTEL_ID_IS_EMPTY_GETVIDEODESC = "100215   ";//酒店ID为空
    public static final String HOTEL_ID_IS_EMPTY_GETHOTELDESC = "10210   ";//酒店ID为空
    public static final String FAILED_TO_GET_TH_HOTEL_PICTURE = "100212   ";//获取酒店图片失败
    /*酒店主业务biz-end*/
}
