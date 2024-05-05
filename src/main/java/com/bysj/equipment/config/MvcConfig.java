package com.bysj.equipment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源访问配置
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Value("${files.upload.userAvatar}")
    private String userAvatar;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源处理
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        //添加头像上传后的访问路径
        registry.addResourceHandler("/"+userAvatar+"/**")
                .addResourceLocations("file:"+fileUploadPath);;
    }

}
