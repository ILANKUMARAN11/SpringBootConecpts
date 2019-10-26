package com.tcs.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Import;

import common.tcs.infy.configuration.EnableDiscoveryClientConfig;
import common.tcs.infy.configuration.SwaggerConfig;

@SpringBootApplication
@EnableCircuitBreaker
@RefreshScope
@Import({ SwaggerConfig.class, EnableDiscoveryClientConfig.class})
public class MicroServiceTwo extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceTwo.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MicroServiceTwo.class);
	}

}
