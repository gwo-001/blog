package com.gwo.myblog.config;

import io.netty.util.internal.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gwo(1552571230 @ qq.com)
 * @Classname Interceptor
 * @Description TODO
 * @Date 2021/10/28 8:59
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       Cookie[] cookies= request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                String token = cookie.getValue();
                if (!StringUtils.hasLength(token)) {
                    throw new Exception("请先登陆");
                }
                break;
            }
            continue;
        }

        return true;
    }
}
