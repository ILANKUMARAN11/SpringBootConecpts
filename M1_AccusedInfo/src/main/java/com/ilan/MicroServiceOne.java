package com.ilan;

import com.ilan.configuration.LogAspect;
import com.ilan.configuration.RestTemplateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
public class MicroServiceOne extends SpringBootServletInitializer {


	//org.springframework.boot.autoconfigure.EnableAutoConfiguration=\com.baeldung.autoconfiguration.MySQLAutoconfiguration

	//Ordering of your configuration class using the Property file
	//org.springframework.boot.autoconfigure.EnableAutoConfiguration=\your.package.AutoConfig1,your.package.AutoConfig2

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{MicroServiceOne.class, RestTemplateConfig.class, LogAspect.class}, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MicroServiceOne.class);
	}
}
