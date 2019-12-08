package com.tcs.infy.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.tcs.infy.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcs.infy.service.AddressService;

import common.tcs.infy.mapper.response.vo.AddressVo;

@RestController
@RequestMapping("/address")
public class AddressController extends VoMapper{
	
	@Autowired
	AddressService addressService;


		//http://<HOSTNAME>:<PORT>/crime/name/<NAME>/ilan.brio
		@GetMapping(value = "/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<AddressVo> findByAccusedName(@PathVariable("name") String name)
		{
			System.out.println("<<<<<<<<<<<Testing Load>>>>>>>>>");
			return addressService.findByAccusedName(name).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
		}

		@GetMapping(value = "/ResponseEntity/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<AddressVo>> findByAccusedNameTest(@PathVariable("name") String name)
		{
			List<AddressVo> lstAddVo=addressService.findByAccusedName(name).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
			//return new ResponseEntity<List<AddressVo>>(lstAddVo, HttpStatus.OK);
			//return ResponseEntity.ok().body(lstAddVo);
			return ResponseEntity.ok(lstAddVo);
		}


		@PostMapping(value = "/save/address/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public Address saveAddress(@RequestBody Address address)
		{
			return addressService.save(address);
		}
		
}
