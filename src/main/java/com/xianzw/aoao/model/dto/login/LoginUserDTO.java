package com.xianzw.aoao.model.dto.login;

import com.xianzw.aoao.model.dto.login.common.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 登录用户
 * @author xianzw
 * @date 2020年5月26日下午10:07:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LoginUserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8782454631060012294L;

	//名称
    private String name;

    //用户名
    private String username;

    //锁定
    private Integer locked = 0;
	
}
