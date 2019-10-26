package com.tcs.infy.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import com.tcs.infy.entity.Address;
import com.tcs.infy.repository.AddressRepo;
import com.tcs.infy.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService
{
	Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
    AddressRepo addressRepo;
	

	
	
	
	@Transactional
	@Override
	public List<Address> findByAccusedName(String name)
	{
		return addressRepo.findByAccusedName(name);
	}



	@Transactional
	@Override
	public Address save(Address crime) {

		return addressRepo.save(crime);
	}



	@Transactional
	@Override
	public List<Address> saveAll(List<Address> crimeLst) {

		return addressRepo.saveAll(crimeLst);
	}


}
