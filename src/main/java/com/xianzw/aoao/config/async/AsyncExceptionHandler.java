package com.xianzw.aoao.config.async;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import com.xianzw.aoao.common.CustomException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	 public void handleUncaughtException(Throwable ex, Method method, Object... params) {
	        log.info("Async method has uncaught exception, params: " + params);

	        if (ex instanceof CustomException) {
	        	CustomException customException = (CustomException) ex;
	            log.info("asyncException:"  + customException.getMessage());
	        }

	        log.error("Exception :", ex);
	    }

}
