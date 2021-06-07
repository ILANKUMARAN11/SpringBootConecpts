package com.ilan.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrimeVo {
	
	
	private String accusedName;
	
	private String crime;
	
	private int crimeCount;
	
	private Date arrestedOn;
	
}
