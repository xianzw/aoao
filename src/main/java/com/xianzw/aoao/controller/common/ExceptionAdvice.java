package com.xianzw.aoao.controller.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.xianzw.aoao.common.ServiceException;

import lombok.extern.log4j.Log4j2;

/**
 * 统一异常处理
 * @author xianzw
 * @date 2020年5月23日上午11:10:38
 */
@ControllerAdvice
@RestController
@Log4j2
public class ExceptionAdvice extends BaseController {
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	/**
	 * 
	 * 异常日志记录
	 *
	 * @param e
	 */
	private void logErrorRequest(Exception e) {
	    String info = String.format("报错API URL: %s%nQuery String: %s",
	            httpServletRequest.getRequestURI(),
	            httpServletRequest.getQueryString());
	    log.error(info);
	    log.error(e.getMessage(), e);
	    String ipInfo = "报错访问者IP信息：" + httpServletRequest.getRemoteAddr() + "," + httpServletRequest.getRemoteHost();
	    log.error(ipInfo);
	}
	
	/**
	 * 缺少参数
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	protected HttpResult<?> missingServletRequestParameter(MissingServletRequestParameterException exception) {
	    logErrorRequest(exception);
	    return responseError(ResultCode.RESULT_CODE_ERROR_LACK_PARAMETER, exception);
	}
	
	/**
	 * 参数格式有误
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
	protected HttpResult<?> typeMismatch(Exception exception) {
	    logErrorRequest(exception);
	    return responseError(ResultCode.RESULT_CODE_ERROR_TYPE_MISMATCH, exception);
	}
	
	/**
	 * 参数校验异常
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected HttpResult<?> methodArgumentNotValid(MethodArgumentNotValidException exception) {
	    logErrorRequest(exception);
	    return responseError(ResultCode.RESULT_CODE_ERROR_METHOD_ARGUMENT_NOT_VALID, exception);
	}
	
	/**
	 * 不支持的请求类型
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected HttpResult<?> httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
	    logErrorRequest(exception);
	    return responseError(ResultCode.RESULT_CODE_ERROR_METHOD_NOT_SUPPORTED, exception);
	}
	
	/**
	 * 其他异常
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({HttpClientErrorException.class, IOException.class, Exception.class})
	protected HttpResult<?> commonException(Exception exception) {
	    logErrorRequest(exception);
	    return responseError(ResultCode.RESULT_CODE_ERROR, exception);
	}
	
	/**
	 * 登录异常
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({IncorrectCredentialsException.class, UnknownAccountException.class})
	protected HttpResult<?> loginException(Exception exception) {
		logErrorRequest(exception);
		return responseHttpResult(ResultCode.RESULT_CODE_LOGGED_IN_ERROR, "用户名或密码错误", null);
	}
	
	/**
	 * 业务层异常
	 *
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	protected HttpResult<?> serviceException(ServiceException serviceException) {
	    logErrorRequest(serviceException);
	    return responseError(serviceException);
	}
	
}
