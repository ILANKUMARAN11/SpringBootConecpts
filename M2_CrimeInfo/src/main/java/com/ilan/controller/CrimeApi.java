package com.ilan.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ilan.entity.Crime;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



public interface CrimeApi {
	



	@ApiOperation(value = "Fetch Crime by Name", notes="fetch Crime Info",nickname = "Crime Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = Crime[].class) })
		@GetMapping(value = "/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Crime> findByAccusedName(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN") @PathVariable("name") String name);

	@ApiOperation(value = "Fetch Crime Count greater than ?", notes="fetch Crime Info",nickname = "Crime Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = Crime[].class) })
	 	@GetMapping(value = "/count/{countNo}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Crime> crimeCountGreaterThan(@ApiParam(value = "Crime Count as input", required = true, defaultValue = "2") @PathVariable("countNo") int count);



	@ApiOperation(value = "Fetch Crime Count greater than ?", notes="fetch Crime Info",nickname = "Crime Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = Crime[].class) })
	 	@GetMapping(value = "/name/count/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Crime> findByAccusedNameAndCrimeCount(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN")  @RequestParam("accusedName") String name, @ApiParam(value = "Crime Count as input", required = true, defaultValue = "1") @RequestParam(value = "arrestedCount") int count);


	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = Crime[].class) })
	 	@PostMapping(value = "/save/all/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Crime> saveAllCrime(@RequestBody List<Crime> accused);


	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List of Crime", response = Crime.class) })
	 	@PostMapping(value = "/save/only/one/crime/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	    public Crime saveCrime(@RequestBody Crime accused);

	 	


	 	
	 	
	   
}
