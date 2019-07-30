package com.bowen.myblog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.interceptor
 * @ClassName: WebConfig
 * @Author: Bowen
 * @Description: 拦截类定义
 * @Date: 2019/7/26 11:38
 * @Version: 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin");
    }
}
