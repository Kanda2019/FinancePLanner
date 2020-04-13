package com.personal.financeplanner.model;

public class Investment {
	private int investmentId;
	private String month;
	private String investmentType;
	private String amountInvested;
	private String currentValue;
	
	public int getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getInvestmentType() {
		return investmentType;
	}
	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
	public String getAmountInvested() {
		return amountInvested;
	}
	public void setAmountInvested(String amountInvested) {
		this.amountInvested = amountInvested;
	}
	public String getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

}
