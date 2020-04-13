package com.personal.financeplanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Investment")
public class InvestmentEntity {
	
	@Id
	private int id;
	private String month;
	private String investmentType;
	private String amountInvested;
	private String currentValue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
