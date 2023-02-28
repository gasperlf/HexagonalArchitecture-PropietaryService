package com.powerup.user.infraestructure.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class CustomFeignConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

}
