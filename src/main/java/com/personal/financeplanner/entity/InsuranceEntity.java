package com.personal.financeplanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Insurance")
public class InsuranceEntity {
	
	@Id
	private int id;
	private String insuranceType;
	private String personInsured;
	private String amountInsured;
	private String premium;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getPersonInsured() {
		return personInsured;
	}
	public void setPersonInsured(String personInsured) {
		this.personInsured = personInsured;
	}
	public String getAmountInsured() {
		return amountInsured;
	}
	public void setAmountInsured(String amountInsured) {
		this.amountInsured = amountInsured;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
}
