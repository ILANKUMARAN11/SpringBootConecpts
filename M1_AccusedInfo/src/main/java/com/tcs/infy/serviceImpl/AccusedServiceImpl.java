package com.tcs.infy.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import com.tcs.infy.controller.VoMapper;
import com.tcs.infy.entity.Accused;
import com.tcs.infy.repository.AccusedRepo;
import com.tcs.infy.service.AccusedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccusedServiceImpl implements AccusedService {

	Logger logger = LoggerFactory.getLogger(AccusedServiceImpl.class);
	
	@Autowired
	AccusedRepo accusedRepo;
	


	@Transactional
	@Override
	public List<Accused> findByAccusedName(String name) {

		return accusedRepo.findByAccusedName(name);
	}

	@Transactional
	@Override
	public List<Accused> findByGender(String gender) {

		return accusedRepo.findByGender(gender);
	}

	@Transactional
	@Override
	public Accused findByAdharNo(String adharNo) {

		return accusedRepo.findByAdharNo(adharNo);
	}

	@Transactional
	@Override
	public Accused save(Accused accused) {

		return accusedRepo.save(accused);
	}

	@Transactional
	@Override
	public List<Accused> saveAll(List<Accused> accusedLst) {

		return accusedRepo.saveAll(accusedLst);
	}
	


}
