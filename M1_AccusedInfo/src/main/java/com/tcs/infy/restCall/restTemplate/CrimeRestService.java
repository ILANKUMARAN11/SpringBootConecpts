package com.tcs.infy.restCall.restTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import common.tcs.infy.mapper.response.vo.Crime;
import common.tcs.infy.tcs.infy.response.ResponseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class CrimeRestService {

    @Autowired
    RestTemplate restTemplate;

    private String crimeMicroService="http://MicroServiceTwo";


    @HystrixCommand(fallbackMethod ="crimeLstFallback" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="6"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="5000")

    })
    public List<Crime> findByCrimeAccusedNameOnly(String name)
    {
        ResponseEntity<Crime[]>  rs1= restTemplate.getForEntity(crimeMicroService+"/crime/name/"+name+"/ilan.brio",Crime[].class);
        return Arrays.asList(rs1.getBody());
    }

    @HystrixCommand(fallbackMethod ="crimeLstFallback" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="6"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="5000")

    })
    public List<Crime> findByCrimeAccusedNameAndCount(String name)
    {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(crimeMicroService+"/crime/name/count/ilan.brio")
                .queryParam("accusedName", "ILAN")
                .queryParam("arrestedCount", 1);

        ResponseEntity<Crime[]>  rs2= restTemplate.getForEntity(uri.toUriString(),Crime[].class);

        return Arrays.asList(rs2.getBody());
    }

    @HystrixCommand(fallbackMethod = "crimeFallback")
    public Crime saveByCrime(Crime crime)
    {
        HttpEntity<Crime> request = new HttpEntity<>(crime);
        ResponseEntity<Crime> rs1 = restTemplate.postForEntity(crimeMicroService+"/crime/save/only/one/crime/ilan.brio", request, Crime.class);
        return rs1.getBody();
    }


    private Crime crimeFallback(Crime crime)
    {
        return crime;
    }

    private List<Crime> crimeLstFallback(String name)
    {
        return Arrays.asList(new Crime("Dummy","Dummy",0,new Date()));
    }
}
