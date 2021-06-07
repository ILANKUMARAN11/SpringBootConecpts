package com.ilan.model;

import com.ilan.dao.entity.Accused;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccusedCrime {

    private Accused accused;
    private CrimeVo crime;
}
