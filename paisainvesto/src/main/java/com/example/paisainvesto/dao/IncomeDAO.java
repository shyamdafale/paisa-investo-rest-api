package com.example.paisainvesto.dao;

import java.util.List;

import com.example.paisainvesto.model.Income;

public interface IncomeDAO {

	List<Income> getAllIncomes();

	Income getIncomesById(String incomeId);

	Income addNewIncome(Income income);

}
