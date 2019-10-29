package com.tcs.infy.controller;



import com.tcs.infy.entity.Address;
import common.tcs.infy.mapper.response.vo.AddressVo;

import java.util.function.Function;

public class VoMapper {

    Function<Address,AddressVo> entityToVo
            = new Function<Address,AddressVo>() {

        public AddressVo apply(Address t) {
            AddressVo requiredObj = new AddressVo();
            requiredObj.setAccusedName(t.getAccusedName());
            requiredObj.setArea(t.getArea());
            requiredObj.setCountry(t.getCountry());
            requiredObj.setDistrict(t.getDistrict());
            requiredObj.setDoorNo(t.getDoorNo());
            requiredObj.setPinCode(t.getPinCode());
            requiredObj.setState(t.getState());
            requiredObj.setStreetName(t.getStreetName());
            return requiredObj;
        }
    };
}
