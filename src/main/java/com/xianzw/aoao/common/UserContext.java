package com.xianzw.aoao.common;

/**
 * user上下文
 * @author xianzw
 * @date 2020年5月26日下午10:04:33
 */
public class UserContext implements AutoCloseable{

	
	static final ThreadLocal<String> current = new ThreadLocal<>();
	 
    public UserContext(String username) {
        current.set(username);
    }
 
    public static String getCurrentUser() {
        return current.get();
    }
 
    public void close() {
        current.remove();
    }

}
