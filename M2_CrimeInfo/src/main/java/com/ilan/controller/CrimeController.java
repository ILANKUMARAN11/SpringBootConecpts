package com.ilan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilan.entity.Crime;
import com.ilan.service.CrimeService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/crime")
public class CrimeController implements CrimeApi{

    @Autowired
    CrimeService accusedService;


    @Override
    @GetMapping(value = "/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Crime> findByAccusedName(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN") @PathVariable("name") String name){

        return accusedService.findByAccusedName(name);
    }

    @Override
    public List<Crime> crimeCountGreaterThan(int count)
    {
        return accusedService.crimeCountGreaterThan(count);
    }



    @Override
    public List<Crime> findByAccusedNameAndCrimeCount(String name,int count)
    {
        return accusedService.findByAccusedNameAndCrimeCount(name,count);
    }


    @Override
    public List<Crime> saveAllCrime(List<Crime> accused)
    {
        return accusedService.saveAll(accused);
    }


    @Override
    public Crime saveCrime(Crime accused)
    {
        return accusedService.save(accused);
    }

}
