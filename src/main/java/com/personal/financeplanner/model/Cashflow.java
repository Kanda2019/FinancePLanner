package com.personal.financeplanner.model;

import java.io.Serializable;


public class Cashflow implements Serializable{
	private static final long serialVersionUID = 1L;
	private int cashflowId;
	private String month;
	private String income;
	private String expense;
	private String emi;
	private String investment;
	private String savings;
	
	public int getCashflowId() {
		return cashflowId;
	}
	public void setCashflowId(int cashflowId) {
		this.cashflowId = cashflowId;
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
