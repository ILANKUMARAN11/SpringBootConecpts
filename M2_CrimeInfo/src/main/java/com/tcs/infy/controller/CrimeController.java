package com.tcs.infy.controller;

import java.util.List;


import com.tcs.infy.entity.Crime;
import com.tcs.infy.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class CrimeController {
	
	@Autowired
	CrimeService accusedService;


		//http://<HOSTNAME>:<PORT>/crime/name/<NAME>/ilan.brio
		@GetMapping(value = "/crime/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Crime> findByAccusedName(@PathVariable("name") String name)
		{
			return accusedService.findByAccusedName(name);
		}
	
		//http://<HOSTNAME>:<PORT>/crime/count/<COUNT>/ilan.brio	
	 	@GetMapping(value = "/crime/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Crime> crimeCountGreaterThan(@PathVariable("countNo") int count)
	    {
	 		return accusedService.crimeCountGreaterThan(count);
	    }
	 	


	 	//http://<HOSTNAME>:<PORT>/crime/name/count/ilan.brio?accusedName=<ACCUSED_NAME>&count=<ARRESTED_COUNT>
	 	@GetMapping(value = "/crime/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Crime> findByAccusedNameAndCrimeCount(@RequestParam("accusedName") String name,@RequestParam(value = "arrestedCount") int count)
	    {
    		return accusedService.findByAccusedNameAndCrimeCount(name,count);
	    }
	 	
	 	
	 	//http://<HOSTNAME>:<PORT>/save/all/crime/ilan.brio
	 	@PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Crime> saveAllCrime(@RequestBody List<Crime> accused)
	    {
    		return accusedService.saveAll(accused);
	    }
	 	
	 	
	 	//http://<HOSTNAME>:<PORT>/save/only/one/crime/ilan.brio
	 	@PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public Crime saveCrime(@RequestBody Crime accused)
	    {
	 		return accusedService.save(accused);
	    }
	    
	 	


	 	
	 	
	   
}
