package com.ilan.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;


import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;



@Configuration
public class RestTemplateConfig
{


	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
//		clientHttpRequestFactory.setConnectTimeout(9000);
//		clientHttpRequestFactory.setReadTimeout(9000);
//		return new RestTemplate(clientHttpRequestFactory);

		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;


}
