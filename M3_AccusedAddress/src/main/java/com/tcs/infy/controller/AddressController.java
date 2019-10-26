package com.tcs.infy.controller;

import java.util.List;


import com.tcs.infy.entity.Address;
import com.tcs.infy.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class AddressController {
	
	@Autowired
	AddressService addressService;


		//http://<HOSTNAME>:<PORT>/crime/name/<NAME>/ilan.brio
		@GetMapping(value = "/address/by/name/{name}/ilan.brio",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Address> findByAccusedName(@PathVariable("name") String name)
		{
			return addressService.findByAccusedName(name);
		}

}
