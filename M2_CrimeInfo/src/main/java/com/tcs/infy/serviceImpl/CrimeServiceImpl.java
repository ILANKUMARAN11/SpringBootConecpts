package com.tcs.infy.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import com.tcs.infy.controller.VoMapper;
import com.tcs.infy.entity.Crime;
import com.tcs.infy.repository.CrimeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.infy.service.CrimeService;



@Service
public class CrimeServiceImpl implements CrimeService
{
	Logger logger = LoggerFactory.getLogger(CrimeServiceImpl.class);

	@Autowired
	CrimeRepo crimeRepo;
	
	@Transactional
	@Override
	public List<Crime> crimeCountGreaterThan(int count)
	{
		return crimeRepo.findByCrimeCountGreaterThanOrderByAccusedNameDesc(count);
	}
	
	
	
	@Transactional
	@Override
	public List<Crime> findByAccusedName(String name)
	{
		return crimeRepo.findByAccusedName(name);
	}



	@Transactional
	@Override
	public Crime save(Crime crime) {

		return crimeRepo.save(crime);
	}



	@Transactional
	@Override
	public List<Crime> saveAll(List<Crime> crimeLst) {

		return crimeRepo.saveAll(crimeLst);
	}




	@Override
	public List<Crime> findByAccusedNameAndCrimeCount(String name, int count) {

		return crimeRepo.findByAccusedNameAndCrimeCount(name,count);
	}
	

}
