package com.ilan.model;

import com.ilan.dao.entity.Accused;

public class AccusedCrime {

    private Accused accused;
    private CrimeVo crime;

    public AccusedCrime(){}

    public Accused getAccused() {
        return accused;
    }

    public void setAccused(Accused accused) {
        this.accused = accused;
    }

    public CrimeVo getCrime() {
        return crime;
    }

    public void setCrime(CrimeVo crime) {
        this.crime = crime;
    }
}
