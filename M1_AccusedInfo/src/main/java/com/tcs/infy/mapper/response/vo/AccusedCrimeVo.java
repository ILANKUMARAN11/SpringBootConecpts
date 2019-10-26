package com.tcs.infy.mapper.response.vo;

import com.tcs.infy.entity.Accused;
import common.tcs.infy.mapper.response.vo.Crime;

public class AccusedCrimeVo {

    private Accused accused;
    private Crime crime;

    public AccusedCrimeVo(){}

    public Accused getAccused() {
        return accused;
    }

    public void setAccused(Accused accused) {
        this.accused = accused;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }
}
