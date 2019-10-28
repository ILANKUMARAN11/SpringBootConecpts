package com.tcs.infy.controller;

import java.util.HashMap;
import java.util.Map;

import com.tcs.infy.entity.Accused;
import com.tcs.infy.mapper.response.vo.AccusedCrimeVo;
import com.tcs.infy.restCall.feign.CrimeFeignClient;
import com.tcs.infy.restCall.restTemplate.AddressRestService;
import com.tcs.infy.restCall.restTemplate.CrimeRestService;
import com.tcs.infy.service.AccusedService;

import common.tcs.infy.mapper.response.vo.Crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/accused")
public class AccusedController {

	@Autowired
	AccusedService accusedService;

	@Autowired
	CrimeFeignClient crimeFeign;

	@Autowired
    CrimeRestService crimeRestTemplate;

	@Autowired
	AddressRestService addressRestService;


	@GetMapping(value = "/restTemplate/name/{name}/ranjani.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map findByAccusedNameRestTemplate(@PathVariable("name") String name)
	{
		Map mp=new HashMap();
		mp.put("Accused Info",accusedService.findByAccusedName(name));
		mp.put("Crime Info",crimeRestTemplate.findByCrimeAccusedNameOnly(name));
		mp.put("Address Info",addressRestService.findByAddressNameOnly(name));
		return mp;
	}

	
	@GetMapping(value = "/feign/name/{name}/ranjani.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map findByAccusedNameFeign(@PathVariable("name") String name)
    {
 		Map mp=new HashMap();
 		mp.put("Accused Info",accusedService.findByAccusedName(name));
 		mp.put("Crime Info ",crimeFeign.findByAccusedName(name));
 		return mp;
    }


	@PostMapping(value = "/save/both/Accused/Crime/ranjani.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map saveBoth(@RequestBody AccusedCrimeVo accusedCrimeVo)
	{
		Map mp=new HashMap();
		Accused accused=accusedService.save(accusedCrimeVo.getAccused());
		Crime crime=crimeRestTemplate.saveByCrime(accusedCrimeVo.getCrime());
		mp.put("Accused SAVED",accused);
		mp.put("Crime SAVED",crime);
		return mp;
	}





}
