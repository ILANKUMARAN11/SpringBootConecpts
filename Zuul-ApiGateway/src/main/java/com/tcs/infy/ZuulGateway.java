package com.tcs.infy;

import com.tcs.infy.filter.PostFilter;
import com.tcs.infy.filter.PreFilter;
import com.tcs.infy.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.tcs.infy.filter.ErrorFilter;


@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulGateway extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZuulGateway.class);
	}
}