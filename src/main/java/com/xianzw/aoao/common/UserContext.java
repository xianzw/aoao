package com.xianzw.aoao.common;

import com.xianzw.aoao.model.dto.login.LoginUserDTO;

/**
 * user上下文
 * @author xianzw
 * @date 2020年5月26日下午10:04:33
 */
public class UserContext implements AutoCloseable{

	
	static final ThreadLocal<LoginUserDTO> current = new ThreadLocal<>();
	 
    public UserContext(LoginUserDTO loginUserDTO) {
        current.set(loginUserDTO);
    }
 
    public static LoginUserDTO getCurrentUser() {
        return current.get();
    }
 
    public void close() {
        current.remove();
    }

}
