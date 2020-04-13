package com.personal.financeplanner.model;

public class FinancialGoal {
	private int goalId;
	private String goalName;
	private String amountRequired;
	private String duration;
	private String amountSaved;
	
	public int getGoalId() {
		return goalId;
	}
	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getAmountRequired() {
		return amountRequired;
	}
	public void setAmountRequired(String amountRequired) {
		this.amountRequired = amountRequired;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAmountSaved() {
		return amountSaved;
	}
	public void setAmountSaved(String amountSaved) {
		this.amountSaved = amountSaved;
	}

}
