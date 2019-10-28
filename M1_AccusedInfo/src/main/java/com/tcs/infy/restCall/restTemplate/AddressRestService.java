package com.tcs.infy.restCall.restTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import common.tcs.infy.mapper.response.vo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressRestService {


    @Autowired
    RestTemplate restTemplate;

    private String addressMicroService="http://MicroServiceThree";


    @HystrixCommand(fallbackMethod = "addressLstFallback", commandKey="HystrixCommandKey")
    public List<Address> findByAddressNameOnly(String name)
    {
        ResponseEntity<Address[]> rs1= restTemplate.getForEntity(addressMicroService+"/address/name/"+name+"/ilan.brio",Address[].class);
        return Arrays.asList(rs1.getBody());
    }

    public List<Address> addressLstFallback(String name)
    {
        return Arrays.asList(new Address("Dummy","Dummy","Dummy","Dummy","Dummy","Dummy","Dummy","Dummy"));
    }
}
