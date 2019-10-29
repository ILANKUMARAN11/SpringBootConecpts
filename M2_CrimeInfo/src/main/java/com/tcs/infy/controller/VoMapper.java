package com.tcs.infy.controller;


import com.tcs.infy.entity.Crime;
import common.tcs.infy.mapper.response.vo.CrimeVo;

import java.util.function.Function;

public class VoMapper {

    Function<Crime,CrimeVo> entityToVo
            = new Function<Crime,CrimeVo>() {

        public CrimeVo apply(Crime t) {
            CrimeVo requiredObj = new CrimeVo();
            requiredObj.setAccusedName(t.getAccusedName());
            requiredObj.setArrestedOn(t.getArrestedOn());
            requiredObj.setCrime(t.getCrime());
            requiredObj.setCrimeCount(t.getCrimeCount());
            return requiredObj;
        }
    };
}
