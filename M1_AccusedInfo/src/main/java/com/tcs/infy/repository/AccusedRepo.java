package com.tcs.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.infy.entity.Accused;

@Repository
public interface AccusedRepo extends JpaRepository<Accused, Long>{
	
	List<Accused> findByAccusedName(String name);
	
	List<Accused> findByGender(String gender);
	
	Accused findByAdharNo(String gender);

}
