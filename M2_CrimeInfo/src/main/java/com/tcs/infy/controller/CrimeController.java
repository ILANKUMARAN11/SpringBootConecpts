package com.tcs.infy.controller;

import java.util.List;
import java.util.stream.Collectors;


import com.tcs.infy.entity.Crime;
import com.tcs.infy.service.CrimeService;
import common.tcs.infy.mapper.response.vo.CrimeVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/crime")
public class CrimeController extends VoMapper{
	
	@Autowired
	CrimeService accusedService;


	@ApiOperation(value = "Fetch Crime by Name", notes="fetch Crime Info",nickname = "Crime Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = CrimeVo[].class) })
		@GetMapping(value = "/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CrimeVo> findByAccusedName(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN") @PathVariable("name") String name)
		{
			return accusedService.findByAccusedName(name).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
		}

	@ApiOperation(value = "Fetch Crime Count greater than ?", notes="fetch Crime Info",nickname = "Crime Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = CrimeVo[].class) })
	 	@GetMapping(value = "/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<CrimeVo> crimeCountGreaterThan(@ApiParam(value = "Crime Count as input", required = true, defaultValue = "2") @PathVariable("countNo") int count)
	    {
	 		return accusedService.crimeCountGreaterThan(count).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
	    }



	@ApiOperation(value = "Fetch Crime Count greater than ?", notes="fetch Crime Info",nickname = "Crime Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = CrimeVo[].class) })
	 	@GetMapping(value = "/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<CrimeVo> findByAccusedNameAndCrimeCount(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN")  @RequestParam("accusedName") String name, @ApiParam(value = "Crime Count as input", required = true, defaultValue = "1") @RequestParam(value = "arrestedCount") int count)
	    {
    		return accusedService.findByAccusedNameAndCrimeCount(name,count).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
	    }


	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = CrimeVo[].class) })
	 	@PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<CrimeVo> saveAllCrime(@RequestBody List<Crime> accused)
	    {
    		return accusedService.saveAll(accused).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
	    }


	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = CrimeVo.class) })
	 	@PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public CrimeVo saveCrime(@RequestBody Crime accused)
	    {
	 		return entityToVo.apply(accusedService.save(accused));
	    }
	    
	 	


	 	
	 	
	   
}
