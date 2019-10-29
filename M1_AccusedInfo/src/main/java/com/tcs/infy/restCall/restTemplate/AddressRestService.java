package com.tcs.infy.restCall.restTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import common.tcs.infy.mapper.response.vo.AddressVo;
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
    public List<AddressVo> findByAddressNameOnly(String name)
    {
        ResponseEntity<AddressVo[]> rs1= restTemplate.getForEntity(addressMicroService+"/address/name/"+name+"/ilan.brio",AddressVo[].class);
        return Arrays.asList(rs1.getBody());
    }

    public List<AddressVo> addressLstFallback(String name)
    {
        return Arrays.asList(new AddressVo("Dummy","Dummy","Dummy","Dummy","Dummy","Dummy","Dummy","Dummy"));
    }
}
