package com.tcs.infy.restCall.feign;

import java.util.List;

import common.tcs.infy.mapper.response.vo.CrimeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="MicroServiceTwo",fallback = CrimeFeignFallback.class)
public interface CrimeFeignClient {
	
	
	@GetMapping(value = "/crime/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> crimeCountGreaterThan(@PathVariable("countNo") int count);
 	
 	@GetMapping(value = "/crime/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> findByAccusedName(@PathVariable("name") String name);
    
 	
 	@GetMapping(value = "/crime/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> findByAccusedNameAndCrimeCount(@RequestParam("accusedName") String name, @RequestParam(value = "arrestedCount") int count);
 	
 	
 	@PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrimeVo> saveAllCrime(@RequestBody List<CrimeVo> accused);
 	
 	
 	@PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public CrimeVo saveCrime(@RequestBody CrimeVo accused);


}
