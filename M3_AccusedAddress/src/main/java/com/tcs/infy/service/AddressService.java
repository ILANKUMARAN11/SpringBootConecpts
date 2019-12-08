package com.tcs.infy.service;

import java.util.List;

import com.tcs.infy.entity.Address;

public interface AddressService {
	
	Address save(Address address);
	
	List<Address> saveAll(List<Address> addressList );

	List <Address> findByAccusedName(String name);
	

}
