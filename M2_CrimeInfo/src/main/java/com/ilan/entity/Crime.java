package com.ilan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
