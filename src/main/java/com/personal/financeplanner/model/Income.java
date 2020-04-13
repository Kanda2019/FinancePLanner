package com.personal.financeplanner.model;

public class Income {
	private int incomeId;
	private String month;
	private String incomeSource;
	private String amount;
	
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getIncomeSource() {
		return incomeSource;
	}
	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
