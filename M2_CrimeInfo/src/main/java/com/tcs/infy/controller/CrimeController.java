package com.tcs.infy.controller;

import java.util.List;
import java.util.stream.Collectors;


import com.tcs.infy.entity.Crime;
import com.tcs.infy.service.CrimeService;
import common.tcs.infy.mapper.response.vo.CrimeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/crime")
public class CrimeController extends VoMapper{
	
	@Autowired
	CrimeService accusedService;


		//http://<HOSTNAME>:<PORT>/crime/name/<NAME>/ilan.brio
		@GetMapping(value = "/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CrimeVo> findByAccusedName(@PathVariable("name") String name)
		{
			return accusedService.findByAccusedName(name).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
		}
	
		//http://<HOSTNAME>:<PORT>/crime/count/<COUNT>/ilan.brio	
	 	@GetMapping(value = "/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<CrimeVo> crimeCountGreaterThan(@PathVariable("countNo") int count)
	    {
	 		return accusedService.crimeCountGreaterThan(count).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
	    }
	 	


	 	//http://<HOSTNAME>:<PORT>/crime/name/count/ilan.brio?accusedName=<ACCUSED_NAME>&count=<ARRESTED_COUNT>
	 	@GetMapping(value = "/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<CrimeVo> findByAccusedNameAndCrimeCount(@RequestParam("accusedName") String name,@RequestParam(value = "arrestedCount") int count)
	    {
    		return accusedService.findByAccusedNameAndCrimeCount(name,count).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
	    }
	 	
	 	
	 	//http://<HOSTNAME>:<PORT>/save/all/crime/ilan.brio
	 	@PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<CrimeVo> saveAllCrime(@RequestBody List<Crime> accused)
	    {
    		return accusedService.saveAll(accused).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
	    }
	 	
	 	
	 	//http://<HOSTNAME>:<PORT>/save/only/one/crime/ilan.brio
	 	@PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public CrimeVo saveCrime(@RequestBody Crime accused)
	    {
	 		return entityToVo.apply(accusedService.save(accused));
	    }
	    
	 	


	 	
	 	
	   
}
