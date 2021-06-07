package com.ilan.dao.dbInit;

import java.util.Arrays;
import java.util.List;

import com.ilan.dao.entity.Accused;
import com.ilan.dao.repository.AccusedRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private AccusedRepo accusedRepo;

    @Override
    public void run(String... args) {
        // Delete all
        this.accusedRepo.deleteAll();

        // Crete users
        Accused ilan =  Accused.builder().accusedName("ILAN").age(29).gender("Male").adharNo("ASTTT").build();
        Accused gokul = Accused.builder().accusedName("GOKUL").age(12).gender("Male").adharNo("ADD222").build();
        Accused kiruthika = Accused.builder().accusedName("KIRUTHIKA").age(2).gender("Female").adharNo("GTT").build();
        Accused vela = Accused.builder().accusedName("VELAYUTHAM").age(5).gender("Male").adharNo("HTYU").build();
        Accused manoj = Accused.builder().accusedName("MANOJ").age(3).gender("Male").adharNo("TYUUII").build();


        List<Accused> accusedLst = Arrays.asList(ilan,gokul,kiruthika,vela,manoj);

        // Save to db
        this.accusedRepo.saveAll(accusedLst);
    }
}

