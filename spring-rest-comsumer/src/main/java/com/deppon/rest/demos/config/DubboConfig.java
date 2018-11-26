package com.deppon.rest.demos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class DubboConfig {

    @Bean
    public RestTemplate httpRestTemplate() {
        return new RestTemplate();
    }
}
