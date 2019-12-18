package com.expensemanager.api.transformer;

import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.model.Category;
import com.expensemanager.api.model.Expense;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseTransformer.
 */
public class ExpenseTransformer {

	/**
	 * Gets the expense dto.
	 *
	 * @param expense the expense
	 * @return the expense dto
	 */
	public static ExpenseDto getExpenseDto(Expense expense) {

		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setAmount(expense.getAmount());
		expenseDto.setCategory(CategoryTransformer.getCategoryDto(expense.getCategory()));
		expenseDto.setDate(expense.getDate());
		expenseDto.setDescription(expense.getDescription());
		expenseDto.setTitle(expense.getTitle());
		return expenseDto;

	}

	/**
	 * Gets the expense.
	 *
	 * @param expenseDto the expense dto
	 * @return the expense
	 */
	public static Expense getExpense(ExpenseDto expenseDto) {

		Expense expense = new Expense();
		expense.setAmount(expenseDto.getAmount());
		expense.setCategory(CategoryTransformer.getCategory(expenseDto.getCategory()));
		expense.setDate(expenseDto.getDate());
		expense.setDescription(expenseDto.getDescription());
		expense.setTitle(expenseDto.getTitle());
		return expense;

	}
}
