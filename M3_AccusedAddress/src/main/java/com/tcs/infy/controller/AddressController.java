package com.tcs.infy.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			return addressService.findByAccusedName(name).stream().map(p->{return entityToVo.apply(p);}).collect(Collectors.toList());
		}

}
