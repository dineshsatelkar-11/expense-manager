/*
 * 
 */
package com.expensemanager.api.service;

import java.util.List;

import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.model.Category;


/**
 * The Interface ICategoryService.
 */
public interface ICategoryService {
	
	
	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 * @throws Exception the exception
	 */
	List<CategoryDto> getAllCategory() throws Exception;
	
	/**
	 * Adds the category.
	 *
	 * @param categoryDto the category dto
	 * @return the category dto
	 * @throws Exception the exception
	 */
	CategoryDto addCategory(CategoryDto categoryDto) throws Exception;

	
	
}
