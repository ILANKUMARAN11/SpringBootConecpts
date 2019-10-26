package com.tcs.infy.restCall.feign;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import common.tcs.infy.mapper.response.vo.Crime;


@FeignClient(name="MicroServiceTwo",fallback = CrimeFeignFallback.class)
public interface CrimeFeignClient {
	
	
	@GetMapping(value = "/crime/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Crime> crimeCountGreaterThan(@PathVariable("countNo") int count);
 	
 	@GetMapping(value = "/crime/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Crime> findByAccusedName(@PathVariable("name") String name);
    
 	
 	@GetMapping(value = "/crime/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Crime> findByAccusedNameAndCrimeCount(@RequestParam("accusedName") String name,@RequestParam(value = "arrestedCount") int count);
 	
 	
 	@PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Crime> saveAllCrime(@RequestBody List<Crime> accused);
 	
 	
 	@PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public Crime saveCrime(@RequestBody Crime accused);


}
