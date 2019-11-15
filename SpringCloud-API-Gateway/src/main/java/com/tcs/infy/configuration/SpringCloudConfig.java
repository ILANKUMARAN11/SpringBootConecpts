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
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-response", "first-response-header"))
                        //.uri("http://localhost:8010/") //If not using EUREKA(Discovery Server) in you application, then you can provide URL with HOST name and port number.
                        .uri("lb://MicroServiceOne/") // If using EUREKA(Discovery Server) in you application.
                        .id("MicroServiceOne"))

     /*			.route(r -> r.path("/crime/**")
      					//.uri("http://localhost:8020/") //If not using EUREKA(Discovery Server) in you application, then you can provide URL with HOST name and port number.
                        .uri("lb://MicroServiceTwo/") // If using EUREKA(Discovery Server) in you application.
                        .id("MicroServiceTwo"))

                .route(r -> r.path("/address/**")
                		//.uri("http://localhost:8030/") //If not using EUREKA(Discovery Server) in you application, then you can provide URL with HOST name and port number.
                        .uri("lb://MicroServiceThree/") // If using EUREKA(Discovery Server) in you application.
                        .id("MicroServiceThree"))
    */

                .build();
    }




}
