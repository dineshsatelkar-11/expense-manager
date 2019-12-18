package com.expensemanager.api.transformer;

import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.model.Category;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryTransformer.
 */
public class CategoryTransformer {

	/**
	 * Gets the category dto.
	 *
	 * @param category the category
	 * @return the category dto
	 */
	public static CategoryDto getCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName(category.getCategoryName());
		return categoryDto;
	}

	/**
	 * Gets the category.
	 *
	 * @param categoryDto the category dto
	 * @return the category
	 */
	public static Category getCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryName(categoryDto.getCategoryName());
		return category;
	}
	
	
	
	
	
	
	
}
