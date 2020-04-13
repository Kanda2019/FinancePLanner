package com.personal.financeplanner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("FinancialGoal")
public class FinancialGoalEntity {
	
	@Id
	private int id;
	private String goalName;
	private String amountRequired;
	private String duration;
	private String amountSaved;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
