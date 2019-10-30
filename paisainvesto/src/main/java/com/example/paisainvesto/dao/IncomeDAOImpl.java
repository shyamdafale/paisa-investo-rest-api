package com.example.paisainvesto.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.paisainvesto.model.Income;
import com.example.paisainvesto.model.Investment;

import io.swagger.annotations.ApiOperation;


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

	@Override
	public void deleteIncome(String incomeId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("incomeId").is(incomeId));
		Income incomeFromDB =  mongoTemplate.findOne(query, Income.class);		
		mongoTemplate.remove(incomeFromDB);
		
	}
	
	@Override
	public void updateIncome(Income income) {
		Query query = new Query();
		Income incomeFromDB = mongoTemplate.findById(income.getIncomeId(), Income.class);
		if ((income.getIncomeId().equals(incomeFromDB.getIncomeId()))) {
			mongoTemplate.save(incomeFromDB);
		} else {
			System.out.print("Error in updating the income");
		}

	}



}
