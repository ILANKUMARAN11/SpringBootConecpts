package com.tcs.infy.db;

import java.util.Arrays;
import java.util.List;

import com.tcs.infy.entity.Accused;
import com.tcs.infy.repository.AccusedRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
	
    private AccusedRepo accusedRepo;
   

    public DbInit(AccusedRepo accusedRepo) {
        this.accusedRepo = accusedRepo;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.accusedRepo.deleteAll();

        // Crete users
        Accused ilan = new Accused("ILAN",29,"Male","ASTTT");
        Accused gokul = new Accused("GOKUL",12,"Male","ADD222");
        Accused kiruthika = new Accused("KIRUTHIKA",2,"Female","GTT");
        Accused vela = new Accused("VELAYUTHAM",5,"Male","HTYU");
        Accused manoj = new Accused("MANOJ",3,"Male","TYUUII");
        

        List<Accused> accusedLst = Arrays.asList(ilan,gokul,kiruthika,vela,manoj);

        // Save to db
        this.accusedRepo.saveAll(accusedLst);
    }
}

