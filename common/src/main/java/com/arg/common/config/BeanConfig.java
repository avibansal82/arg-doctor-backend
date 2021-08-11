package com.arg.common.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableJpaRepositories
@Configuration
public class BeanConfig {
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
