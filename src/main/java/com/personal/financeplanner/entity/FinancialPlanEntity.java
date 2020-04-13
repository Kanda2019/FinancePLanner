package com.personal.financeplanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("FinancialPlan")
public class FinancialPlanEntity {
	
	@Id
	private int id;
	private String monthAndYear;
	private String income;
	private String expense;
	private String savings;
	private String investment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
