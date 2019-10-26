package com.tcs.infy.db;

import java.util.Arrays;
import java.util.List;

import com.tcs.infy.entity.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.tcs.infy.repository.AddressRepo;

@Service
public class DbInit implements CommandLineRunner {
	
    private AddressRepo addressRepo;
   

    public DbInit(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.addressRepo.deleteAll();

        // Crete users
        Address ilan = new Address("ILAN","112/P6","T Nagar","CHIDAMBARAM","Cuddalore","Tamil Nadu","606001","INDIA");
        Address gokul = new Address("GOKUL","23","Anna Nagar","CHENNAI","CHENNAI","Tamil Nadu","606001","INDIA");
        Address kiruthika = new Address("KIRUTHIKA","112/P6","Durgai Nagar","CHIDAMBARAM","Cuddalore","Tamil Nadu","606001","INDIA");
        Address vela = new Address("VELAYUTHAM","112/P6","Durgai Nagar","CHIDAMBARAM","Cuddalore","Tamil Nadu","606001","INDIA");
        Address manoj = new Address("MANOJ","112/P6","Durgai Nagar","CHIDAMBARAM","Cuddalore","Tamil Nadu","606001","INDIA");
        

        List<Address> crimeLst = Arrays.asList(ilan,gokul,kiruthika,vela,manoj);

        // Save to db
        this.addressRepo.saveAll(crimeLst);
    }
}

