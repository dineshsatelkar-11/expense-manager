package com.expensemanager.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.expensemanager.api.model.Category;
import com.expensemanager.api.model.Expense;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExpenseRepository.
 */
public interface IExpenseRepository extends JpaRepository<Expense, Integer> {

	/**
	 * Find by date after.
	 *
	 * @param after the after
	 * @return the list
	 */
	List<Expense> findByDateAfter(Date after);

	/**
	 * Find by date before.
	 *
	 * @param before the before
	 * @return the list
	 */
	List<Expense> findByDateBefore(Date before);

	/**
	 * Find by date between.
	 *
	 * @param after the after
	 * @param before the before
	 * @return the list
	 */
	List<Expense> findByDateBetween(Date after, Date before);

	/**
	 * Total expense.
	 *
	 * @return the double
	 */
	@Query(value = "SELECT sum(amount) FROM Expense")
	public Double totalExpense();
}
