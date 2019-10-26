package com.tcs.infy.service;

import java.util.List;

import com.tcs.infy.entity.Crime;

public interface CrimeService {
	
	Crime save(Crime crime);
	
	List<Crime> saveAll(List<Crime> crimedLst );

	List<Crime> crimeCountGreaterThan(int count);

	List <Crime> findByAccusedName(String name);
	
	List<Crime> findByAccusedNameAndCrimeCount(String name,int count);
	
}
