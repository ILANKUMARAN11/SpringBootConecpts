package com.ilan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@JsonIgnoreProperties(value = { "primaryKey" }) //json ignore at class level
@Entity
public class Crime {

	@JsonIgnore //json ignore at field level
	@JsonProperty("primaryKey")
	@Id
	@GeneratedValue
	private long id;

	@JsonProperty("AccusedName")
	@Column
	private String accusedName;

	@JsonProperty("CrimeCommitted")
	@Column
	private String crime;

	@JsonProperty("No of time CrimeVo Committed")
	@Column
	private int crimeCount;

	@JsonProperty("ArrestedDate")
	@Column
	@Temporal(TemporalType.DATE)
	private Date arrestedOn;
	
	public Crime(){}
	
	public Crime(String accusedName,String crime,int crimeCount,Date arrestedOn){
		this.accusedName=accusedName;
		this.crime=crime;
		this.crimeCount=crimeCount;
		this.arrestedOn=arrestedOn;
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
	public Date getArrestedOn() {
		return arrestedOn;
	}
	public void setArrestedOn(Date arrestedOn) {
		this.arrestedOn = arrestedOn;
	}
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}

	public int getCrimeCount() {
		return crimeCount;
	}

	public void setCrimeCount(int crimeCount) {
		this.crimeCount = crimeCount;
	}
	
	
	
	
}
