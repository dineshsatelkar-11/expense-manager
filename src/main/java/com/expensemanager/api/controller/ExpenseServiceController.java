package com.expensemanager.api.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.service.IExpenseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseServiceController.
 */
@RestController
@RequestMapping("/expense-controller")
@Api(value = "Expense Management System", description = "Operations pertaining to expense in Expense Management System")
public class ExpenseServiceController {

	/** The expense service. */
	@Autowired
	private IExpenseService expenseService;

	/**
	 * Instantiates a new expense service controller.
	 *
	 * @param expenseService the expense service
	 */
	public ExpenseServiceController(IExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	/**
	 * Adds the expense.
	 *
	 * @param expenseDto the expense dto
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "Add an Expense")
	@PostMapping("/expense")
	public ExpenseDto addExpense(
			@ApiParam(value = "Expense object store in database table", required = true) @Valid @RequestBody ExpenseDto expenseDto)
			throws Exception {
		return expenseService.addExpense(expenseDto);
	}

	/**
	 * Gets the expense.
	 *
	 * @return the expense
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "Get Total  Expense")
	@GetMapping("/getTotalExpense")
	public Double getExpense() throws Exception {
		return expenseService.getTotalExpense();
	}

	/**
	 * Gets the all expense dto.
	 *
	 * @return the all expense dto
	 * @throws Exception the exception
	 */

	@ApiOperation(value = "View a list of Expenses ", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/expenses")
	public ResponseEntity<List<ExpenseDto>> getAllExpenseDto() throws Exception {
		return new ResponseEntity<List<ExpenseDto>>(expenseService.getAllExpense(), HttpStatus.OK);
	}

	/**
	 * Gets the all expense dto by category name.
	 *
	 * @param categoryName the category name
	 * @return the all expense dto by category name
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "Get an expense by Category")
	@GetMapping("/expenses/{categoryName}")
	public ResponseEntity<List<ExpenseDto>> getAllExpenseDtoByCategoryName(
			@ApiParam(value = "category Name to retreived expense object", required = true) @PathVariable("categoryName") String categoryName)
			throws Exception {
		List<ExpenseDto> expenses = expenseService.getAllExpenseByCategoryName(categoryName);
		if (expenses == null)
			throw new ResourceNotFoundException("These Category is not Present in Database :: " + categoryName);

		if (expenses.size() == 0)
			throw new ResourceNotFoundException("Expense  not found for this Category :: " + categoryName);
		return new ResponseEntity<List<ExpenseDto>>(expenses, HttpStatus.OK);

	}

	/**
	 * Gets the all expense dtoafter date.
	 *
	 * @param afterDate the after date
	 * @return the all expense dtoafter date
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "Get an expense List after these Date")
	@GetMapping("/expenses/afterDate/{afterDate}")
	public ResponseEntity<List<ExpenseDto>> getAllExpenseDtoafterDate(
			@ApiParam(value = "Date for  retreived expense object after these date", required = true) @PathVariable("afterDate") Date afterDate)
			throws Exception {
		List<ExpenseDto> expenses = expenseService.getAllExpensAfterDate(afterDate);
		if (expenses.size() == 0)
			throw new ResourceNotFoundException("Expense  not found for   After these Date :: " + afterDate);
		return new ResponseEntity<List<ExpenseDto>>(expenses, HttpStatus.OK);

	}

	/**
	 * Gets the all expense dtobefore date.
	 *
	 * @param beforeDate the before date
	 * @return the all expense dtobefore date
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "Get an expense List Before these Date")
	@GetMapping("/expenses/beforeDate/{beforeDate}")
	public ResponseEntity<List<ExpenseDto>> getAllExpenseDtobeforeDate(
			@ApiParam(value = "Date for  retreived expense object Before these date", required = true) @PathVariable("beforeDate") Date beforeDate)
			throws Exception {
		List<ExpenseDto> expenses = expenseService.getAllExpensBeforeDate(beforeDate);
		if (expenses.size() == 0)
			throw new ResourceNotFoundException("Expense  not found for Before these Date :: " + beforeDate);
		return new ResponseEntity<List<ExpenseDto>>(expenses, HttpStatus.OK);

	}

	/**
	 * Gets the all expense dtobetween date.
	 *
	 * @param afterDate  the after date
	 * @param beforeDate the before date
	 * @return the all expense dtobetween date
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "Get an expense List Between these Date")
	@GetMapping("expenses/Between/{afterDate}/{beforeDate}")
	public ResponseEntity<List<ExpenseDto>> getAllExpenseDtobetweenDate(
			@ApiParam(value = "Date for  retreived expense object Between these date", required = true) @PathVariable("afterDate") Date afterDate,
			@PathVariable("beforeDate") Date beforeDate) throws Exception {
		List<ExpenseDto> expenses = expenseService.getAllExpensBetweenDate(afterDate, beforeDate);
		if (expenses.size() == 0)
			throw new ResourceNotFoundException("Expense  not found for After Date :: " + beforeDate);
		return new ResponseEntity<List<ExpenseDto>>(expenses, HttpStatus.OK);

	}

}
