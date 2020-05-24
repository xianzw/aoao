package com.xianzw.aoao.controller.common;

public class ResultCode {

	public static final String RESULT_CODE_SUCCESS = "10000";  // 处理请求成功
	public static final String RESULT_CODE_FAIL = "10100";  // 处理请求失败
	public static final String RESULT_CODE_ERROR = "10200";  // 请求错误
	public static final String RESULT_CODE_ERROR_METHOD_NOT_SUPPORTED = "10210";  // 不支持的请求类型
	public static final String RESULT_CODE_ERROR_LACK_PARAMETER = "10220";  // 缺少参数
	public static final String RESULT_CODE_ERROR_TYPE_MISMATCH = "10221";  // 参数格式有误
	public static final String RESULT_CODE_ERROR_METHOD_ARGUMENT_NOT_VALID = "10222";  // 参数校验异常
	public static final String RESULT_CODE_NOT_LOGGED_IN = "10300";  // 未登录
	public static final String RESULT_CODE_LOGGED_IN_SUCCESS = "10301";  // 登录成功
	public static final String RESULT_CODE_LOGGED_IN_ERROR = "10302";  // 用户名或密码错误
	public static final String RESULT_CODE_NO_ACCESS = "10400";  // 无权访问
    public static final String RESULT_CODE_SERVER_ERROR = "500";  // 没有对应结果
    
    public static final String DEFAULT_MESSAGE_SUCCESS = "SUCCESS";
    public static final String DEFAULT_MESSAGE_FAIL = "FAIL";
    public static final String DEFAULT_MESSAGE_ERROR = "ERROR";
	
}
