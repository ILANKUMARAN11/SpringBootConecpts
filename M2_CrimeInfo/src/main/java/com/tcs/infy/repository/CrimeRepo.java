package com.tcs.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.infy.entity.Crime;

@Repository
public interface CrimeRepo extends JpaRepository<Crime, Long>{
	
	List<Crime> findByCrimeCountGreaterThanOrderByAccusedNameDesc(int Count);
	
	List<Crime> findByAccusedName(String name);
	
	List<Crime> findByAccusedNameIn(List<String> names);
	
	List<Crime> findByAccusedNameAndCrimeCount(String name,int Count);
	
	

}
