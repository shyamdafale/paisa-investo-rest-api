package com.example.paisainvesto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@ApiModel(description = "All details about the Investment. ")
public class Investment {

	@Id
	private String investmentId;
	private String investmentName;
	private String investmentType;
	private String investmentAmount;

	@ApiModelProperty(notes = " Investment ID")
	public String getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(String investmentId) {
		this.investmentId = investmentId;
	}

	public String getInvestmentName() {
		return investmentName;
	}

	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public String getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(String investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

}