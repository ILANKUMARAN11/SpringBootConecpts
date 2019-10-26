package com.tcs.infy.restCall.feign;

import common.tcs.infy.mapper.response.vo.Crime;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class CrimeFeignFallback implements CrimeFeignClient {


    public List<Crime> crimeCountGreaterThan(int count)
    {
        return crimeLstFallback();
    }


    public List<Crime> findByAccusedName(String name){
        return crimeLstFallback();
    }


    public List<Crime> findByAccusedNameAndCrimeCount(String name,int count){
        return crimeLstFallback();
    }


    public List<Crime> saveAllCrime(List<Crime> accused){
        return crimeLstFallback();
    }


    public Crime saveCrime(Crime accused){
        return crimeFallback();
    }

    private Crime crimeFallback()
    {
        return new Crime("Dummy","Dummy",0,new Date());
    }

    private List<Crime> crimeLstFallback()
    {
        return Arrays.asList(new Crime("Dummy","Dummy",0,new Date()));
    }
}
