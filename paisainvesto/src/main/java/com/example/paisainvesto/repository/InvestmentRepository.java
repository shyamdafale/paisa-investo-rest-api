package com.example.paisainvesto.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.paisainvesto.model.Investment;

@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface InvestmentRepository extends MongoRepository<Investment, String> {
	
	Optional<Investment> findOneByInvestmentId(String investmentId);

}
