package com.tcs.infy.service;

import java.util.List;

import com.tcs.infy.entity.Accused;

public interface AccusedService {
	
	Accused save(Accused accused);
	
	List<Accused> saveAll(List<Accused> accusedLst );

	List<Accused> findByAccusedName(String name);

	List<Accused> findByGender(String gender);

	Accused findByAdharNo(String adharNo);
}
