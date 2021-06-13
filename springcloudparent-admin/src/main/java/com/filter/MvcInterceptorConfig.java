package com.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/adlogon","/admin/logon","/admin/test","/admin/test1");    
        super.addInterceptors(registry);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:D:/new wok/springcloudparent/springcloudparent-user/src/main/webapp/static/");
        registry.addResourceHandler("/static1/**").addResourceLocations("file:D:/new wok/springcloudparent/springcloudparent-admin/src/main/webapp/static1/");
    }

}