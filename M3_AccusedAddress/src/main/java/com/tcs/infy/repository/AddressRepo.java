package com.tcs.infy.repository;

import java.util.List;

import com.tcs.infy.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

	List<Address> findByAccusedName(String name);

}
