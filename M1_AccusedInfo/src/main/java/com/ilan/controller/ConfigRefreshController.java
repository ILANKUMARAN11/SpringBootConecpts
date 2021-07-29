package com.ilan.controller;


import com.ilan.configuration.TestRefreshConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class ConfigRefreshController {

    @Autowired
    RestTemplate restTemplate;


//    @Value("${test.property}")
//    public String testProperty;

    @Autowired
    TestRefreshConfiguration testRefreshConfiguration;


    @Autowired
    @Qualifier("testString")
    String name;

    @GetMapping("/refresh/newValue/")
    public String getRefreshedValue(){
        log.info(">>>>>"+testRefreshConfiguration);
        return testRefreshConfiguration.getName()+" "+name;
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
