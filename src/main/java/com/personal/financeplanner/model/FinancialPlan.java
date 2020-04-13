package com.personal.financeplanner.model;

public class FinancialPlan {
	private int planId;
	private String monthAndYear;
	private String income;
	private String expense;
	private String savings;
	private String investment;
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getMonthAndYear() {
		return monthAndYear;
	}
	public void setMonthAndYear(String monthAndYear) {
		this.monthAndYear = monthAndYear;
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
	public String getSavings() {
		return savings;
	}
	public void setSavings(String savings) {
		this.savings = savings;
	}
	public String getInvestment() {
		return investment;
	}
	public void setInvestment(String investment) {
		this.investment = investment;
	}

}
