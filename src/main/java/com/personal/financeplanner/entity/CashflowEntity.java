package com.personal.financeplanner.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Cashflow")
public class CashflowEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String month;
	private String income;
	private String expense;
	private String emi;
	private String investment;
	private String savings;
	
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
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getEmi() {
		return emi;
	}
	public void setEmi(String emi) {
		this.emi = emi;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}
	public String getSavings() {
		return savings;
	}
	public void setSavings(String savings) {
		this.savings = savings;
	}       
}
