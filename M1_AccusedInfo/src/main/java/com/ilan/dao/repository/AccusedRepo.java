package com.ilan.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ilan.dao.entity.Accused;

@RepositoryRestResource(collectionResourceRel = "Accused", path = "Accused")
@Repository
public interface AccusedRepo extends JpaRepository<Accused, Long>{
	
	List<Accused> findByAccusedName(String name);
	
	List<Accused> findByGender(String gender);
	
	Accused findByAdharNo(String gender);

}
