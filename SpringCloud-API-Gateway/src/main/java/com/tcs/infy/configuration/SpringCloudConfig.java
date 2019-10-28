package com.tcs.infy.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/accused/**")
                        .uri("lb://MicroServiceOne/")
                        .id("MicroServiceOne"))
//                .route(r -> r.path("/crime/**")
//                        .uri("lb://MicroServiceTwo/")
//                        .id("MicroServiceTwo"))
                .route(r -> r.path("/address/**")
                        .uri("lb://MicroServiceThree/")
                        .id("MicroServiceThree"))
                .build();
    }




}
