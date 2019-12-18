package com.expensemanager.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.service.ICategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryServiceController.
 */
@RestController
@RequestMapping("/category-controller")
@Api(value = "Expense Management System", description = "Operations pertaining to category in Expense Management System")
public class CategoryServiceController {

	/** The category service. */
	@Autowired
	private ICategoryService categoryService;

	/**
	 * Adds the category.
	 *
	 * @param categoryDto the category dto
	 * @return the response entity
	 * @throws Exception the exception
	 */

	@ApiOperation(value = "Add a Category")
	@PostMapping("/category")
	public CategoryDto addCategory(
			@ApiParam(value = "Category object store in database table", required = true) @Valid @RequestBody CategoryDto categoryDto)
			throws Exception {
		return categoryService.addCategory(categoryDto);
	}

}
