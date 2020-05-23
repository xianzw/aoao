package com.xianzw.aoao.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @description 自定义异常信息
 * @author xianzw
 * @time 2019年2月27日下午4:20:06
 */
@Getter
@Setter
public class ServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	private String exceptionCode;//异常码
	
	private String exceptionMessage;//异常信息
	
	public ServiceException(String exceptionCode,String exceptionMessage){
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
	}
	
}
