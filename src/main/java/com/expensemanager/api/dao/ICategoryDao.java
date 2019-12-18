package com.expensemanager.api.dao;

import java.util.List;

import com.expensemanager.api.dto.CategoryDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICategoryDao.
 */
public interface ICategoryDao {
	
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
