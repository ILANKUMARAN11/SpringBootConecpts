package com.ilan.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Accused {

	@JsonIgnore
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String accusedName;
	
	@Column
	private int age;
	
	@Column
	private String gender;

	@Column
	private String adharNo;

}
