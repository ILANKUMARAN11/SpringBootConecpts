package com.ilan.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ilan.model.AccusedCrime;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface AccusedApi {
	
	
	@ApiOperation(value = "API by RestTemplate", notes="fetch AccusedVo Info",nickname = "accused Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@GetMapping(value = "/restTemplate/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map findByAccusedNameRestTemplate(@ApiParam(value = "Accused name as input", required = true, defaultValue = "ILAN") @PathVariable("name") String name);


	@ApiOperation(value = "API by Open_Feign", notes="fetch AccusedVo Info",nickname = "accused Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@GetMapping(value = "/feign/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map findByAccusedNameFeign(@ApiParam(value = "Accused name as input", required = true, defaultValue = "MANOJ") @PathVariable("name") String name);


	@ApiOperation(value = "API for Persisting Data", notes="Save AccusedVo Info",nickname = "Save accused Info")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@PostMapping(value = "/save/both/AccusedVo/CrimeVo/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map saveBoth(@RequestBody AccusedCrime accusedCrimeVo);
	
	
	

}
