package com.solequat.businesslogic.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableDiscoveryClient
public class BusinessLogicConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
