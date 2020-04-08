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
 * @author hduser
 *
 */
public class ErrorCode {

	/*认证模块错误码-start*/
	public final static String AUTH_UNKNOWN="30000";
	public final static String AUTH_USER_ALREADY_EXISTS="30001";//用户已存在
	public final static String AUTH_AUTHENTICATION_FAILED="30002";//认证失败
	public final static String AUTH_PARAMETER_ERROR="30003";//用户名密码参数错误，为空
	public final static String AUTH_ACTIVATE_FAILED="30004";//邮件注册，激活失败
	public final static String AUTH_REPLACEMENT_FAILED="30005";//置换token失败
	public final static String AUTH_TOKEN_INVALID="30006";//token无效
	public static final String AUTH_ILLEGAL_USERCODE = "30007";//非法的用户名
	public static final String USER_PWD_ERR = "30008";  // 密码错误
	public static final String USER_ILLEGAL_CODE_ERR = "30009";  // 非法用户账号
	public final static String AUTH_USER_CREATE_FAILED="30010";//用户已存在
	public final static String AUTH_CREATE_FAILED="30011";//创建token失败




	/*认证模块错误码-end*/

	/*第三方接入错误码-start*/
	public static final String URL_PARSE_ERR = "5000";  // 密码错误
	public static final String AUTH_REPLACETOKEN_FAILED = "5001";  // 换取AccessToken失败

	/*第三方接入错误码-end*/
}
