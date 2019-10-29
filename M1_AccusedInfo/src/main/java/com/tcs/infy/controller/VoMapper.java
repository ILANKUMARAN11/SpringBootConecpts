package com.tcs.infy.controller;

import com.tcs.infy.entity.Accused;
import common.tcs.infy.mapper.response.vo.AccusedVo;

import java.util.function.Function;

public class VoMapper {

    Function<Accused, AccusedVo> entityToVo
            = new Function<Accused, AccusedVo>() {

        public AccusedVo apply(Accused t) {
            AccusedVo requiredObj = new AccusedVo();
            requiredObj.setAccusedName(t.getAccusedName());
            requiredObj.setAge(t.getAge());
            requiredObj.setGender(t.getGender());
            requiredObj.setAdharNo(t.getAdharNo());
            return requiredObj;
        }
    };
}
