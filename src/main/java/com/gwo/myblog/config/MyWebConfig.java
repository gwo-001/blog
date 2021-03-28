package com.gwo.myblog.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname MyWebConfig
 * @Description springMvc配置类
 * @Date 2021/3/28 20:40
 * @Created by Gwo(1552571230@qq.com)
 */
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }
}
