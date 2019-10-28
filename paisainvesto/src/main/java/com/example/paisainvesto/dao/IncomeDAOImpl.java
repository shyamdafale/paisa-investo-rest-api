package com.example.paisainvesto.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.paisainvesto.model.Income;


public class IncomeDAOImpl implements IncomeDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Income> getAllIncomes() {
		mongoTemplate.findAll(Income.class);
		return null;
	}

	@Override
	public Income getIncomeById(String incomeId) {

		Query query = new Query();
		query.addCriteria(Criteria.where("incomeId").is(incomeId));
		return mongoTemplate.findOne(query, Income.class);
	}

	@Override
	public Income addNewIncome(Income income) {
		mongoTemplate.save(income);
		// Now, investment object will contain the ID as well
		return income;
	}

}
