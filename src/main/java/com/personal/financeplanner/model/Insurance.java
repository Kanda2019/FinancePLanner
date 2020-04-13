package com.personal.financeplanner.model;

public class Insurance {
	private int insuranceId;
	private String insuranceType;
	private String personInsured;
	private String amountInsured;
	private String premium;
	
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
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
