package com.ilan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilan.entity.Crime;
import com.ilan.repository.CrimeRepo;

@Service
public class CrimeService {
	
	Logger logger = LoggerFactory.getLogger(CrimeService.class);

	@Autowired
	CrimeRepo crimeRepo;
	
	@Transactional
	public List<Crime> crimeCountGreaterThan(int count)
	{
		return crimeRepo.findByCrimeCountGreaterThanOrderByAccusedNameDesc(count);
	}
	
	@Transactional
	public List<Crime> findByAccusedName(String name)
	{
		return crimeRepo.findByAccusedName(name);
	}



	@Transactional
	public Crime save(Crime crime) {

		return crimeRepo.save(crime);
	}



	@Transactional
	public List<Crime> saveAll(List<Crime> crimeLst) {

		return crimeRepo.saveAll(crimeLst);
	}


	@Transactional
	public List<Crime> findByAccusedNameAndCrimeCount(String name, int count) {

		return crimeRepo.findByAccusedNameAndCrimeCount(name,count);
	}
	

}
