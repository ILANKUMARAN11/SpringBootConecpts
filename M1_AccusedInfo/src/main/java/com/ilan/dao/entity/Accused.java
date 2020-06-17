package com.ilan.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public Accused(){}
	
	
	public Accused(String accusedName,int age,String gender,String adharNo){
		this.accusedName=accusedName;
		this.age=age;
		this.gender=gender;
		this.adharNo=adharNo;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccusedName() {
		return accusedName;
	}

	public void setAccusedName(String accusedName) {
		this.accusedName = accusedName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}





}
