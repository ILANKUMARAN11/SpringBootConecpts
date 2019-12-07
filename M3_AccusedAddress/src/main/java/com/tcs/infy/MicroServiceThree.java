package com.tcs.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Import;

import common.tcs.infy.configuration.SwaggerConfig;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@RefreshScope
@EnableDiscoveryClient
@Import({ SwaggerConfig.class})
public class MicroServiceThree extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceThree.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MicroServiceThree.class);
	}

}
