package com.ilan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ilan.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilan.dao.entity.Accused;
import com.ilan.model.AccusedCrime;
import com.ilan.model.CrimeVo;
import com.ilan.restCall.feign.CrimeFeignClient;
import com.ilan.restCall.restTemplate.CrimeRestService;
import com.ilan.service.AccusedService;

import io.swagger.annotations.Api;

@Slf4j
@Api(value = "CrimeVo", description = "ACCUSED DATA INFO",position = 66)
@RestController
@RequestMapping("/accused")
public class AccusedController implements AccusedApi {

	@Autowired
	AccusedService accusedService;

	@Autowired
	CrimeFeignClient crimeFeign;

	@Autowired
    CrimeRestService crimeRestService;



	@Override
	public Map findByAccusedNameRestTemplate(@PathVariable("name") String name)
	{
		log.info("Microservice1 Load Balancing");
		Map mp=new HashMap();
		List<Accused> accusedVoList=accusedService.findByAccusedName(name);
		mp.put("AccusedVo Info",accusedVoList);
		List<CrimeVo> crimeVoList = crimeRestService.findByCrimeAccusedNameOnly(name);
		log.info(crimeVoList.toString());
		mp.put("CrimeVo Info",crimeRestService.findByCrimeAccusedNameOnly(name));
		return mp;
	}

	@Override
	@GetMapping(value = "/feign/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map findByAccusedNameFeign(@PathVariable("name") String name)
    {
 		Map mp=new HashMap();
		List<Accused> accusedVoList=accusedService.findByAccusedName(name);
 		mp.put("AccusedVo Info",accusedVoList);
 		mp.put("CrimeVo Info ",crimeFeign.findByAccusedName(name));
 		return mp;
    }


	@Override
	@PostMapping(value = "/save/both/AccusedVo/CrimeVo/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map saveBoth(@RequestBody AccusedCrime accusedCrimeVo)
	{
		Map mp=new HashMap();
		Accused accusedVo=accusedService.save(accusedCrimeVo.getAccused());
		CrimeVo crime=crimeRestService.saveByCrime(accusedCrimeVo.getCrime());
		mp.put("AccusedVo SAVED",accusedVo);
		mp.put("CrimeVo SAVED",crime);
		return mp;
	}

	@GetMapping(value = "/test/transient")
	public TestModel testTransient(){
		return TestModel.builder()
				.name("Test")
				.delta("test")
				.build();
	}


}
