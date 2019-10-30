package com.example.paisainvesto.dao;

import java.util.List;

import com.example.paisainvesto.model.Income;

public interface IncomeDAO {

	List<Income> getAllIncomes();

	Income getIncomeById(String incomeId);

	Income addNewIncome(Income income);

	void deleteIncome(String incomeId);

	void updateIncome(Income income);

}
