/**
 * 
 */
package com.expensemanager.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensemanager.api.dao.ICategoryDao;
import com.expensemanager.api.dto.CategoryDto;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryService.
 *
 * @author Dinesh
 */


@Service
public class CategoryService implements ICategoryService {

	/** The category dao. */
	@Autowired
	private ICategoryDao categoryDao;
	
	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 */
	@Override
	public List<CategoryDto> getAllCategory() throws Exception  {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory();
	}

	/**
	 * Adds the category.
	 *
	 * @param categoryDto the category dto
	 * @return the category dto
	 */
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) throws Exception {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(categoryDto);
	}

	

}
