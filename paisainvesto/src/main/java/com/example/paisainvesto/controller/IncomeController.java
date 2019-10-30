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

import com.example.paisainvesto.model.Income;
import com.example.paisainvesto.repository.IncomeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/v1")
@Api(value = "PaisaInvesto Management System", description = "Operations pertaining to investors in PaisaInvesto Management System")
public class IncomeController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private final IncomeRepository incomeRepository;

	public IncomeController(IncomeRepository incomeRepository) {
		this.incomeRepository = incomeRepository;
	}

	@ApiOperation(value = "View a list of available incomes", response = Income.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved incomes list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "show-incomes")
	public List<Income> getAllIncomes() {
		LOG.info("Getting all incomes.");
		return incomeRepository.findAll();
	}

	@ApiOperation(value = "View perticular available income", response = List.class)
	@GetMapping(value = "/{incomeId}")
	public Optional<Income> getIncomeById(@PathVariable String incomeId) {
		LOG.info("Getting income with ID: {}.", incomeId);
		return incomeRepository.findOneByIncomeId(incomeId);
	}

	@ApiOperation(value = "Add new income", response = List.class)
	@PostMapping(value = "/add-income")
	public Income addNewIncome(@RequestBody Income income) {
		LOG.info("Saving income");
		return incomeRepository.save(income);
	}

	@ApiOperation(value = "Delete Income", response = String.class)
	@DeleteMapping(value = "/delete-income/{incomeId}")
	public void deleteIncome(@PathVariable String incomeId) {
		LOG.info("Deleting income with ID: {}.", incomeId);
		incomeRepository.deleteById(incomeId);
	}

	@ApiOperation(value = "Update income", response = String.class)
	@PutMapping(value = "/update-income")
	public void updateIncome(@RequestBody Income income) {
		LOG.info("Updating income with ID: {}.", income.getIncomeId());
		incomeRepository.save(income);
	}

}