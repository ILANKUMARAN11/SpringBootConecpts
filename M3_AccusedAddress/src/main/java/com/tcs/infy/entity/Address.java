package com.tcs.infy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Address {

	@JsonIgnore
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String accusedName;
	
	@Column
	private String doorNo;

	@Column
	private String streetName;

	@Column
	private String area;

	@Column
	private String district;
	
	@Column
	private String state;

	@Column
	private String pinCode;

	@Column
	private String country;

	

	
	public Address(){}
	
	public Address(String accusedName, String doorNo, String streetName, String area, String district, String state, String pinCode, String country){
		this.accusedName=accusedName;
		this.doorNo=doorNo;
		this.streetName=streetName;
		this.area=area;
		this.district=district;
		this.state=state;
		this.pinCode=pinCode;
		this.country=country;
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

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
