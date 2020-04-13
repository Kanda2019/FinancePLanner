package com.personal.financeplanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Asset")
public class AssetEntity {

	@Id
	private int id;
	private String assetType;
	private String investedAmount;
	private String investedDate;
	private String currentValue;
	private String returnOnInvestment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(String investedAmount) {
		this.investedAmount = investedAmount;
	}
	public String getInvestedDate() {
		return investedDate;
	}
	public void setInvestedDate(String investedDate) {
		this.investedDate = investedDate;
	}
	public String getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	public String getReturnOnInvestment() {
		return returnOnInvestment;
	}
	public void setReturnOnInvestment(String returnOnInvestment) {
		this.returnOnInvestment = returnOnInvestment;
	}
}
