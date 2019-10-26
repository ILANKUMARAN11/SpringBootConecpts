package com.tcs.infy.db;

import com.tcs.infy.entity.User;
import com.tcs.infy.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User testAdmin = new User("testAdmin",passwordEncoder.encode("testAdmin"),"ADMIN","ACCESS_1,ACCESS_2,ACCESS_3","","","");
        User testManager = new User("testManager",passwordEncoder.encode("testManager"),"MANAGER","ACCESS_2,ACCESS_3","","","");
        User testUser = new User("testUser",passwordEncoder.encode("testUser"),"USER","ACCESS_3","","","");


        User ilanAdmin = new User("ilanAdmin",passwordEncoder.encode("ilanAdmin"),"ADMIN","ACCESS_1,ACCESS_2,ACCESS_3","","","");
        User ilanManager = new User("ilanManager",passwordEncoder.encode("ilanManager"),"MANAGER","ACCESS_2,ACCESS_3","","","");
        User ilanUser = new User("ilanUser",passwordEncoder.encode("ilanUser"),"USER","ACCESS_3","","","");

        User umaAdmin = new User("umaAdmin",passwordEncoder.encode("umaAdmin"),"ADMIN","ACCESS_1,ACCESS_2,ACCESS_3","","","");
        User umaManager = new User("umaManager",passwordEncoder.encode("umaManager"),"MANAGER","ACCESS_2,ACCESS_3","","","");
        User umaUser = new User("umaUser",passwordEncoder.encode("umaUser"),"USER","ACCESS_3","","","");


        List<User> users = Arrays.asList(ilanAdmin,ilanManager,ilanUser,umaAdmin,umaManager,umaUser,testAdmin,testManager,testUser);

        // Save to db
        this.userRepository.saveAll(users);
    }
}

