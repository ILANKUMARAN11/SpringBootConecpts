package com.tcs.infy.restCall.restTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import common.tcs.infy.mapper.response.vo.CrimeVo;

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
    public List<CrimeVo> findByCrimeAccusedNameOnly(String name)
    {
        ResponseEntity<CrimeVo[]>  rs1= restTemplate.getForEntity(crimeMicroService+"/crime/name/"+name+"/ilan.brio",CrimeVo[].class);
        return Arrays.asList(rs1.getBody());
    }

    @HystrixCommand(fallbackMethod ="crimeLstFallback" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="6"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="5000")

    })
    public List<CrimeVo> findByCrimeAccusedNameAndCount(String name)
    {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(crimeMicroService+"/crime/name/count/ilan.brio")
                .queryParam("accusedName", "ILAN")
                .queryParam("arrestedCount", 1);

        ResponseEntity<CrimeVo[]>  rs2= restTemplate.getForEntity(uri.toUriString(),CrimeVo[].class);

        return Arrays.asList(rs2.getBody());
    }

    @HystrixCommand(fallbackMethod = "crimeFallback")
    public CrimeVo saveByCrime(CrimeVo crime)
    {
        HttpEntity<CrimeVo> request = new HttpEntity<>(crime);
        ResponseEntity<CrimeVo> rs1 = restTemplate.postForEntity(crimeMicroService+"/crime/save/only/one/crime/ilan.brio", request, CrimeVo.class);
        return rs1.getBody();
    }


    private CrimeVo crimeFallback(CrimeVo crime)
    {
        return crime;
    }

    private List<CrimeVo> crimeLstFallback(String name)
    {
        return Arrays.asList(new CrimeVo("Dummy","Dummy",0,new Date()));
    }
}
