package com.ilan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilan.dao.entity.Accused;
import com.ilan.dao.repository.AccusedRepo;

@Service
public class AccusedService {
	

	Logger logger = LoggerFactory.getLogger(AccusedService.class);
	
	@Autowired
	AccusedRepo accusedRepo;

	@Transactional
	public List<Accused> findByAccusedName(String name) {

		return accusedRepo.findByAccusedName(name);
	}

	@Transactional
	public List<Accused> findByGender(String gender) {

		return accusedRepo.findByGender(gender);
	}

	@Transactional
	public Accused findByAdharNo(String adharNo) {

		return accusedRepo.findByAdharNo(adharNo);
	}

	@Transactional
	public Accused save(Accused accused) {

		return accusedRepo.save(accused);
	}

	@Transactional
	public List<Accused> saveAll(List<Accused> accusedLst) {

		return accusedRepo.saveAll(accusedLst);
	}
	



}
