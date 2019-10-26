package com.tcs.infy.repository;

import com.tcs.infy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    Optional<User> findByUsername(String username);

}
