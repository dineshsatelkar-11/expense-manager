package com.expensemanager.api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.model.Expense;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExpenseService.
 */
public interface IExpenseService {

	/**
	 * Gets the all expense.
	 *
	 * @return the all expense
	 * @throws Exception the exception
	 */
	List<ExpenseDto> getAllExpense() throws Exception;

	/**
	 * Adds the expense.
	 *
	 * @param expenseDto the expense dto
	 * @return the expense dto
	 * @throws Exception the exception
	 */
	ExpenseDto addExpense(ExpenseDto expenseDto) throws Exception;

	/**
	 * Gets the all expense by category name.
	 *
	 * @param categoryName the category name
	 * @return the all expense by category name
	 * @throws Exception the exception
	 */
	List<ExpenseDto> getAllExpenseByCategoryName(String categoryName) throws Exception;

	/**
	 * Gets the all expens after date.
	 *
	 * @param after the after
	 * @return the all expens after date
	 */
	List<ExpenseDto> getAllExpensAfterDate(Date after);

	/**
	 * Gets the all expens before date.
	 *
	 * @param before the before
	 * @return the all expens before date
	 */
	List<ExpenseDto> getAllExpensBeforeDate(Date before);

	/**
	 * Gets the all expens between date.
	 *
	 * @param after  the after
	 * @param before the before
	 * @return the all expens between date
	 */
	List<ExpenseDto> getAllExpensBetweenDate(Date after, Date before);

	/**
	 * Gets the total expense.
	 *
	 * @return the total expense
	 */
	 Double getTotalExpense() throws Exception;
}
