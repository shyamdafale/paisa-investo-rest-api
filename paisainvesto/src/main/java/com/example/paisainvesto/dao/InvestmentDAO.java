package com.example.paisainvesto.dao;

import java.util.List;

import com.example.paisainvesto.model.Investment;

public interface InvestmentDAO {
	
	List<Investment> getAllInvestments();

	Investment getInvestmentById(String investmentId);

	Investment addNewInvestment(Investment investment);

	void deleteInvestment(String investmentId);
	
	void updateInvestment(Investment investment);
	
}
