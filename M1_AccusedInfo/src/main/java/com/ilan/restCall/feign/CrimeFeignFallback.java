package com.ilan.restCall.feign;

import org.springframework.stereotype.Component;

import com.ilan.model.CrimeVo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class CrimeFeignFallback implements CrimeFeignClient {


    public List<CrimeVo> crimeCountGreaterThan(int count)
    {
        return crimeLstFallback();
    }


    public List<CrimeVo> findByAccusedName(String name){
        return crimeLstFallback();
    }


    public List<CrimeVo> findByAccusedNameAndCrimeCount(String name, int count){
        return crimeLstFallback();
    }


    public List<CrimeVo> saveAllCrime(List<CrimeVo> accused){
        return crimeLstFallback();
    }


    public CrimeVo saveCrime(CrimeVo accused){
        return crimeFallback();
    }

    private CrimeVo crimeFallback()
    {
        return new CrimeVo("Feign-Dummy","Feign-Dummy",0,new Date());
    }

    private List<CrimeVo> crimeLstFallback()
    {
        return Arrays.asList(new CrimeVo("Feign-Dummy","Feign-Dummy",0,new Date()));
    }
}
