package com.gwo.myblog.utils;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Gwo(1552571230 @ qq.com)
 * @Classname JWTutil
 * @Description TODO
 * @Date 2021/10/28 9:29
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTutil {

    private static String header;

    private static String tokenPrefix;

    private static String salt;

    private static long expireTime;


    public void setHeader(String header) {
        JWTutil.header = header;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JWTutil.tokenPrefix = tokenPrefix;
    }

    public void setSalt(String salt) {
        JWTutil.salt = salt;
    }

    public void setExpireTime(long expireTime) {
        JWTutil.expireTime = expireTime;
    }

    /**
     * 创建token
     * @param sub 用户账号
     * @return 用户
     */
    public static String createToken(String sub) {
        return tokenPrefix+ OAuth2ResourceServerProperties.Jwt.
    }

    /**
     * 校验token的有效性
     * @param token token的String
     * @return token是否有效
     */
    public static boolean verifyToken(String token) {
        return true;
    }


}
