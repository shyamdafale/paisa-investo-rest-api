package com.example.paisainvesto.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paisainvesto.model.Investment;
import com.example.paisainvesto.repository.InvestmentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/v1")
@Api(value = "PaisaInvesto Management System", description = "Operations pertaining to investors in PaisaInvesto Management System")
public class InvestmentController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private final InvestmentRepository investmentRepository;

	public InvestmentController(InvestmentRepository investmentRepository) {
		this.investmentRepository = investmentRepository;
	}

	@ApiOperation(value = "View a list of available investments", response = Investment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved investments list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "show-investments")
	public List<Investment> getAllInvestments() {
		LOG.info("Getting all investments.");
		return investmentRepository.findAll();
	}

	@ApiOperation(value = "View perticular available investments", response = List.class)
	@GetMapping(value = "/{investmentId}")
	public Optional<Investment> getInvestmentById(@PathVariable String investmentId) {
		LOG.info("Getting investment with ID: {}.", investmentId);
		return investmentRepository.findOneByInvestmentId(investmentId);
	}

	@ApiOperation(value = "Add new investments", response = List.class)
	@PostMapping(value = "/add-investment")
	public Investment addNewInvestment(@RequestBody Investment investment) {
		LOG.info("Saving investment");
		return investmentRepository.save(investment);
	}
	
	@ApiOperation(value = "Delete investment", response = String.class)
	@DeleteMapping(value = "/delete-investment/{investmentId}")
	public void deleteInvestment(@PathVariable String investmentId) {
		LOG.info("Deleting investment with ID: {}.", investmentId);
		investmentRepository.deleteById(investmentId);
	}

	@ApiOperation(value = "Update investment", response = String.class)
	@PutMapping(value = "/update-investment")
	public void updateInvestment(@RequestBody Investment investment) {
		LOG.info("Updating investment with ID: {}.", investment.getInvestmentId());
		investmentRepository.save(investment);
	}

}