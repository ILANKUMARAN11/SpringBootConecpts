package com.ilan.controller;


import com.ilan.configuration.TestRefreshConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RefreshScope
public class ConfigRefreshController {

    @Autowired
    RestTemplate restTemplate;


    @Value("${test.property:EmptyValue}")
    public String testProperty;

    @Autowired
    TestRefreshConfiguration testRefreshConfiguration;


    @GetMapping("/refresh/newValue/")
    public String getRefreshedValue(){
        //configRefresh();
        //log.info(">>>>>"+testRefreshConfiguration);
        return testRefreshConfiguration.getName()+" "+testProperty;
    }


    @GetMapping(value = "hit/actuator/by/code",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> configRefresh(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String[]> rs = restTemplate.exchange("http://Accused/actuator/refresh", HttpMethod.POST,entity,String[].class);
        return Arrays.asList(rs.getBody());
    }



}
