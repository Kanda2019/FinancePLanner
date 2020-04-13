package com.personal.financeplanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Income")
public class IncomeEntity {
	
	@Id
	private int id;
	private String month;
	private String incomeSource;
	private String amount;
	
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
