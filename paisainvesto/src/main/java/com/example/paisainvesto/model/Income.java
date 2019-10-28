package com.example.paisainvesto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(description = "All details about the Income. ")
public class Income {

	@Id
	private String incomeId;
	private String incomeName;
	private String incomeType;
	private String incomeAmount;
	private String incomeNote;

	@ApiModelProperty(notes = " Income ID")
	public String getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}

	public String getIncomeName() {
		return incomeName;
	}

	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public String getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(String incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public String getIncomeNote() {
		return incomeNote;
	}

	public void setIncomeNote(String incomeNote) {
		this.incomeNote = incomeNote;
	}

}