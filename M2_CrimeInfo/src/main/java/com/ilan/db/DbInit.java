package com.ilan.db;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ilan.entity.Crime;
import com.ilan.repository.CrimeRepo;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private CrimeRepo crimeRepo;


    @Override
    public void run(String... args) {

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        // Delete all
        this.crimeRepo.deleteAll();

        // Crete users
        Crime ilan = Crime.builder().accusedName("ILAN").crime("Murder").crimeCount(1).arrestedOn(new Date()).build();
        Crime gokul = Crime.builder().accusedName("GOKUL").crime("Bomb Blast").crimeCount(2).arrestedOn(new Date()).build();
        Crime kiruthika = Crime.builder().accusedName("KIRUTHIKA").crime("Chain Snatching").crimeCount(12).arrestedOn(new Date()).build();
        Crime vela = Crime.builder().accusedName("VELAYUTHAM").crime("Robbery").crimeCount(23).arrestedOn(new Date()).build();
        Crime manoj = Crime.builder().accusedName("MANOJ").crime("Chain snatching").crimeCount(34).arrestedOn(new Date()).build();


        List<Crime> crimeLst = Arrays.asList(ilan,gokul,kiruthika,vela,manoj);

        // Save to db
        this.crimeRepo.saveAll(crimeLst);
    }
}

