package com.example.paisainvesto.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.paisainvesto.model.Income;

@Repository
public interface IncomeRepository extends MongoRepository<Income, String> {
	
	Optional<Income> findOneByIncomeId(String incomeId);

}
