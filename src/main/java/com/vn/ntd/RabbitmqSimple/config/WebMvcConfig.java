package com.vn.ntd.RabbitmqSimple.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The Class WebMvcConfig
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        long MAX_AGE_SECS = 3600;
        registry.addMapping( "/**" )
                .allowedOrigins( "*" )
                .allowedMethods( "HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE" )
                .maxAge( MAX_AGE_SECS );
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
