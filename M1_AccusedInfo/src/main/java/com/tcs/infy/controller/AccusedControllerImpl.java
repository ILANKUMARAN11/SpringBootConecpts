package com.tcs.infy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.infy.mapper.response.vo.AccusedCrime;
import com.tcs.infy.restCall.feign.CrimeFeignClient;
import com.tcs.infy.restCall.restTemplate.AddressRestService;
import com.tcs.infy.restCall.restTemplate.CrimeRestService;
import com.tcs.infy.service.AccusedService;

import common.tcs.infy.mapper.response.vo.AccusedVo;
import common.tcs.infy.mapper.response.vo.CrimeVo;
import io.swagger.annotations.Api;

@Api(value = "CrimeVo", description = "ACCUSED DATA INFO",position = 66)
@RestController
@RequestMapping("/accused")
public class AccusedControllerImpl extends VoMapper implements AccusedController {

	@Autowired
	AccusedService accusedService;

	@Autowired
	CrimeFeignClient crimeFeign;

	@Autowired
    CrimeRestService crimeRestTemplate;

	@Autowired
	AddressRestService addressRestService;


	@Override
	@GetMapping(value = "/restTemplate/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map findByAccusedNameRestTemplate(@PathVariable("name") String name)
	{
		Map mp=new HashMap();
		List<AccusedVo> accusedVoList=accusedService.findByAccusedName(name).stream().map(p->{
			return entityToVo.apply(p);
		}).collect(Collectors.toList());

		mp.put("AccusedVo Info",accusedVoList);
		mp.put("CrimeVo Info",crimeRestTemplate.findByCrimeAccusedNameOnly(name));
		mp.put("AddressVo Info",addressRestService.findByAddressNameOnly(name));
		return mp;
	}

	@Override
	@GetMapping(value = "/feign/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map findByAccusedNameFeign(@PathVariable("name") String name)
    {
 		Map mp=new HashMap();
		List<AccusedVo> accusedVoList=accusedService.findByAccusedName(name).stream().map(p->{
			return entityToVo.apply(p);
		}).collect(Collectors.toList());
 		mp.put("AccusedVo Info",accusedVoList);
 		mp.put("CrimeVo Info ",crimeFeign.findByAccusedName(name));
 		return mp;
    }


	@Override
	@PostMapping(value = "/save/both/AccusedVo/CrimeVo/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map saveBoth(@RequestBody AccusedCrime accusedCrimeVo)
	{
		Map mp=new HashMap();
		AccusedVo accusedVo=entityToVo.apply(accusedService.save(accusedCrimeVo.getAccused()));
		CrimeVo crime=crimeRestTemplate.saveByCrime(accusedCrimeVo.getCrime());
		mp.put("AccusedVo SAVED",accusedVo);
		mp.put("CrimeVo SAVED",crime);
		return mp;
	}


}
