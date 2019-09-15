package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.company.controller")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver getVieWResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setOrder(1);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths("/",
                "/WEB-INF/views/",
                "/WEB-INF/views/entities/",
                "/WEB-INF/views/addEntities/",
                "/WEB-INF/views/showEntities/",
                "/WEB-INF/views/deleteEntities/",
                "/WEB-INF/views/editEntities/");
        return configurer;
    }
}