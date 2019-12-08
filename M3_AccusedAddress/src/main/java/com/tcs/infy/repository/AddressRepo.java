package com.tcs.infy.repository;

import java.util.List;

import com.tcs.infy.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "Address", path = "Address")
@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

	List<Address> findByAccusedName(String name);

}
