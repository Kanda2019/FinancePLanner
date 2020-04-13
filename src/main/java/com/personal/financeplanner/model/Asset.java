package com.personal.financeplanner.model;

public class Asset {

	private int assetId;
	private String assetType;
	private String investedAmount;
	private String investedDate;
	private String currentValue;
	private String returnOnInvestment;
	
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
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
