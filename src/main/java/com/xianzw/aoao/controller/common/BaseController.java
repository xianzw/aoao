package com.xianzw.aoao.controller.common;

import com.xianzw.aoao.common.ServiceException;

/**
 * controller基类
 * @author xianz
 *
 */
public abstract class BaseController {

	
	/**
	 * @param <T>
	 * 登录成功消息
	 * @Description:   
	 * @param: @param code
	 * @param: @param data
	 * @param: @return      
	 * @return: HttpResult      
	 * @throws
	 */
	protected <T> HttpResult<T> loginSuccess(T data){
		HttpResult<T> httpResult = new HttpResult<>();
		httpResult.setResultMessage(ResultCode.DEFAULT_MESSAGE_SUCCESS);
		httpResult.setResultCode(ResultCode.RESULT_CODE_LOGGED_IN_SUCCESS);
		httpResult.setResultData(data);
		return httpResult;
	}
	
	/**
	 * @param <T>
     * 返回成功消息
     * @Description:   
     * @param: @param code
     * @param: @param data
     * @param: @return      
     * @return: HttpResult      
     * @throws
     */
	protected <T> HttpResult<T> responseSuccess(T data){
    	HttpResult<T> httpResult = new HttpResult<>();
    	httpResult.setResultMessage(ResultCode.DEFAULT_MESSAGE_SUCCESS);
    	httpResult.setResultCode(ResultCode.RESULT_CODE_SUCCESS);
    	httpResult.setResultData(data);
        return httpResult;
    }
    
    /**
     * 返回成功消息
     * @Description:   
     * @param: @return      
     * @return: HttpResult      
     * @throws
     */
	protected <T> HttpResult<T> responseSuccess() {
        HttpResult<T> httpResult = new HttpResult<>();
        httpResult.setResultMessage(ResultCode.DEFAULT_MESSAGE_SUCCESS);
        httpResult.setResultCode(ResultCode.RESULT_CODE_SUCCESS);
        httpResult.setResultData(null);
        return httpResult;
    }

    /**
     * 返回失败消息
     * @Description:   
     * @param: @param code
     * @param: @return      
     * @return: HttpResult      
     * @throws
     */
	protected <T> HttpResult<T> responseFail() {
    	HttpResult<T> HttpResult = new HttpResult<>();
    	HttpResult.setResultCode(ResultCode.RESULT_CODE_FAIL);
    	HttpResult.setResultMessage(ResultCode.DEFAULT_MESSAGE_FAIL);
    	HttpResult.setResultData(null);
    	return HttpResult;
    }
    /**
     * 返回失败消息带数据
     * @Description:   
     * @param: @param code
     * @param: @return      
     * @return: HttpResult      
     * @throws
     */
	protected <T> HttpResult<T> responseFail(T data) {
    	HttpResult<T> HttpResult = new HttpResult<>();
    	HttpResult.setResultCode(ResultCode.RESULT_CODE_FAIL);
    	HttpResult.setResultMessage(ResultCode.DEFAULT_MESSAGE_FAIL);
    	HttpResult.setResultData(null);
    	return HttpResult;
    }
	
    /**
     * 返回错误消息
     * @Description:   
     * @param: @param code
     * @param: @return      
     * @return: HttpResult      
     * @throws
     */
	protected <T> HttpResult<T> responseError(ServiceException serviceException) {
    	HttpResult<T> HttpResult = new HttpResult<>();
    	HttpResult.setResultCode(serviceException.getExceptionCode());
    	HttpResult.setResultMessage(serviceException.getExceptionMessage());
    	HttpResult.setResultData(null);
    	return HttpResult;
    }
	/**
	 * 返回错误消息带数据
	 * @Description:   
	 * @param: @param code
	 * @param: @return      
	 * @return: HttpResult      
	 * @throws
	 */
	protected <T> HttpResult<T> responseError(ServiceException businessException,T data) {
		HttpResult<T> HttpResult = new HttpResult<>();
		HttpResult.setResultCode(businessException.getExceptionCode());
		HttpResult.setResultMessage(businessException.getExceptionMessage());
		HttpResult.setResultData(data);
		return HttpResult;
	}
	
	/**
	 * 异常返回错误消息
	 * @Description:   
	 * @param: @param code
	 * @param: @return      
	 * @return: HttpResult      
	 * @throws
	 */
	protected <T> HttpResult<T> responseError(String code,Exception exception) {
		HttpResult<T> HttpResult = new HttpResult<>();
		HttpResult.setResultCode(code);
		HttpResult.setResultMessage(exception.getMessage());
		HttpResult.setResultData(null);
		return HttpResult;
	}
	
	/**
	 * 返回数据
	 * @Description:   
	 * @param: @param code
	 * @param: @return      
	 * @return: HttpResult      
	 * @throws
	 */
	protected <T> HttpResult<T> responseHttpResult(String code,String message,T data) {
		HttpResult<T> HttpResult = new HttpResult<>();
		HttpResult.setResultCode(code);
		HttpResult.setResultMessage(message);
		HttpResult.setResultData(data);
		return HttpResult;
	}
}
