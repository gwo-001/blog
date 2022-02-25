package com.gwo.myblog.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Gwo
 * @Classname MyWebConfig
 * @Description springMvc配置类
 * @Date 2021/3/28 20:40
 * @Created by Gwo(1552571230@qq.com)
 */
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    /**
     * 我们自定义的拦截器需要在这里注册才能生效
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/signUp")
                .excludePathPatterns("/auth/login");
    }
}
