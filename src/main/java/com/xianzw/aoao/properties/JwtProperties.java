package com.xianzw.aoao.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * JwtProperties
 * @author xianzw
 * @date 2020年5月24日上午10:23:19
 */
@ConfigurationProperties(prefix = "token")
@Data
public class JwtProperties {
    //token过期时间，单位分钟
    Integer tokenExpireTime;
    //刷新Token过期时间，单位分钟
    Integer refreshTokenExpireTime;
    //Shiro缓存有效期，单位分钟
    Integer shiroCacheExpireTime;
    //token加密密钥
    String secretKey;
}