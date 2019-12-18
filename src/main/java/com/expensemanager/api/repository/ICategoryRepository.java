package com.expensemanager.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensemanager.api.model.Category;
import com.expensemanager.api.model.Expense;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICategoryRepository.
 */
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	
	/**
	 * Find by category name.
	 *
	 * @param categoryName the category name
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Category> findByCategoryName(String categoryName) throws Exception;
}
