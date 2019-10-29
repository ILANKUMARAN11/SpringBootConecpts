package com.tcs.infy.mapper.response.vo;

import com.tcs.infy.entity.Accused;
import common.tcs.infy.mapper.response.vo.CrimeVo;

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
