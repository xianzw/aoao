package com.xianzw.aoao.model.dto.login;

import com.xianzw.aoao.model.dto.common.BaseDTO;

import lombok.Data;

/**
 * 当前登录用户dto
 * @author xianzw
 * @date 2020年5月27日上午9:22:43
 *
 */
@Data
public class LoginUserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -902815044484797247L;
	
	//名称
    private String name;

    //用户名
    private String username;

    //锁定
    private Integer locked = 0;
	
}
