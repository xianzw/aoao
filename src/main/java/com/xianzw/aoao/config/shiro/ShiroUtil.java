package com.xianzw.aoao.config.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * ShiroUtil
 * @author xianzw
 * @date 2020年5月23日下午9:43:17
 */
public class ShiroUtil {

    public static final Integer PWD_HASH_ITERATIONS  = 825;
    public static final String PWD_ALGORITHM_NAME  = "sha-256";
	
    
    /**
     * 生成密码<br/>
     * 
     * @param pwd
     * @param salt
     * @return
     */
    public static String generatePwdEncrypt(String pwd, String salt) {
        return new SimpleHash(PWD_ALGORITHM_NAME, pwd, ByteSource.Util.bytes(salt), PWD_HASH_ITERATIONS).toHex();
    }

    /**
     * 生成盐值<br/>
     * 
     * @return
     */
    public static String generateSalt() {
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }
}
