/*
 * arg license
 *
 */

package com.arg.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouter {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()

                .route(f -> f.path("/auth/**")
                        .filters(f1 -> f1.rewritePath("/auth/(?<segment>.*)", "/$\\{segment}"))
                        .uri("lb://auth"))

                .route(f -> f.path("/doctor-service/**")
                        .filters(f1 -> f1.rewritePath("/doctor-service/(?<segment>.*)", "/$\\{segment}"))
                        .uri("lb://doctor-service"))

                .build();


    }

}
