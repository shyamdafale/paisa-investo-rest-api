package com.example.paisainvesto.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.paisainvesto.model.Investment;

public class InvestmentDAOImpl implements InvestmentDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Investment> getAllInvestments() {
		mongoTemplate.findAll(Investment.class);
		return null;
	}

	@Override
	public Investment getInvestmentById(String investmentId) {

		Query query = new Query();
		query.addCriteria(Criteria.where("investmentId").is(investmentId));
		return mongoTemplate.findOne(query, Investment.class);
	}

	@Override
	public Investment addNewInvestment(Investment investment) {
		mongoTemplate.save(investment);
		// Now, investment object will contain the ID as well
		return investment;
	}

}
