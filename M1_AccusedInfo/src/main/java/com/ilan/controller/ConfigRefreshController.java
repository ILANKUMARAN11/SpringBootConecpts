package com.ilan.controller;


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

@RefreshScope
@RestController
public class ConfigRefreshController {

    @Value("${test.property}")
    public String testProperty;


    @Qualifier("TestRest")
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get/New/Value")
    public String getRefreshedValue(){
        return testProperty;
    }

    @GetMapping(value = "/refresh/configServer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> configRefresh(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String[]> rs=restTemplate.exchange("http://localhost:8010/actuator/refresh", HttpMethod.POST,entity,String[].class);
        return Arrays.asList(rs.getBody());
    }
}
