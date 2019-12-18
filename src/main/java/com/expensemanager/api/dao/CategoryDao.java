package com.expensemanager.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.model.Category;
import com.expensemanager.api.repository.ICategoryRepository;
import com.expensemanager.api.transformer.CategoryTransformer;
import com.expensemanager.api.transformer.ExpenseTransformer;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryDao.
 */
@Transactional
@Repository
public class CategoryDao implements ICategoryDao {

	/** The category repository. */
	@Autowired
	private ICategoryRepository categoryRepository;

	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 * @throws Exception the exception
	 */
	@Override
	public List<CategoryDto> getAllCategory() throws Exception {
		// TODO Auto-generated method stub
		List<CategoryDto> list = new ArrayList<>();
		categoryRepository.findAll().forEach(e -> list.add(CategoryTransformer.getCategoryDto(e)));
		return list;
	}

	/**
	 * Adds the category.
	 *
	 * @param categoryDto the category dto
	 * @return the category dto
	 * @throws Exception the exception
	 */
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) throws Exception {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository
				.findByCategoryName(categoryDto.getCategoryName());		
		if (categories.isEmpty()) {
			return CategoryTransformer
					.getCategoryDto(categoryRepository.save(CategoryTransformer.getCategory(categoryDto)));
		} else {
			return CategoryTransformer.getCategoryDto(categories.get(0));
		}
		
	}


}
