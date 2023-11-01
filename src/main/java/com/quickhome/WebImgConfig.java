package com.quickhome;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/31 23:23
 */

@Component
public class WebImgConfig implements WebMvcConfigurer {

    private String filePath = "E:/Spring boot/uploads";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+filePath+"/");
    }
}