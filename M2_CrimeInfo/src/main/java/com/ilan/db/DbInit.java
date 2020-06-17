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
        Crime ilan = new Crime("ILAN","Murder",1,new Date());
        Crime gokul = new Crime("GOKUL","Bomb Blast",2,new Date());
        Crime kiruthika = new Crime("KIRUTHIKA","Chain Snatching",12,new Date());
        Crime vela = new Crime("VELAYUTHAM","Robbery",23,new Date());
        Crime manoj = new Crime("MANOJ","Chain snatching",34,new Date());
        

        List<Crime> crimeLst = Arrays.asList(ilan,gokul,kiruthika,vela,manoj);

        // Save to db
        this.crimeRepo.saveAll(crimeLst);
    }
}

