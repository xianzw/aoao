package com.xianzw.aoao.controller.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6530932137532820700L;
	
	private String resultCode;
    private String resultMessage;
    private T resultData;

}
