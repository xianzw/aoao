package com.xianzw.aoao.config.jwt;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * JwtToken
 * @author xianzw
 * @date 2020年5月24日下午12:34:48
 */
public class JwtToken extends UsernamePasswordToken {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7901761634633647429L;
	/**
     * Token
     */
    private String token;
    
    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
