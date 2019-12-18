package com.expensemanager.api.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.model.Category;
import com.expensemanager.api.model.Expense;
import com.expensemanager.api.repository.ICategoryRepository;
import com.expensemanager.api.repository.IExpenseRepository;
import com.expensemanager.api.transformer.CategoryTransformer;
import com.expensemanager.api.transformer.ExpenseTransformer;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseDao.
 */
@Transactional
@Repository
public class ExpenseDao implements IExpenseDao {

	/** The expense repository. */
	@Autowired
	private IExpenseRepository expenseRepository;

	/** The category repository. */
	@Autowired
	private ICategoryRepository categoryRepository;

	/**
	 * Gets the all expense.
	 *
	 * @return the all expense
	 * @throws Exception the exception
	 */
	@Override
	public List<ExpenseDto> getAllExpense() throws Exception {
		// TODO Auto-generated method stub
		try {
			List<ExpenseDto> list = new ArrayList<>();
			expenseRepository.findAll().forEach(expense -> list.add(ExpenseTransformer.getExpenseDto(expense)));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Adds the expense.
	 *
	 * @param expenseDto the expense dto
	 * @return the expense dto
	 * @throws Exception the exception
	 */
	@Override
	public ExpenseDto addExpense(ExpenseDto expenseDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Category> categories = categoryRepository
					.findByCategoryName(expenseDto.getCategory().getCategoryName());
			Expense expense = ExpenseTransformer.getExpense(expenseDto);
			if (categories.isEmpty()) {
				expense=expenseRepository.save(expense);
				Category category=expense.getCategory();
				List<Expense> expenses=new ArrayList<>();
				expenses.add(expense);
				category.setExpenses(expenses);
				categoryRepository.save(category);
				return ExpenseTransformer.getExpenseDto(expense);
			    
			} else {
				expense.setCategory(categories.get(0));
				expense = expenseRepository.save(expense);
				boolean e = categories.get(0).getExpenses().add(expense);
				categoryRepository.save(categories.get(0));
				return ExpenseTransformer.getExpenseDto(expenseRepository.save(expense));

			}

			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Gets the all expense by category name.
	 *
	 * @param categoryName the category name
	 * @return the all expense by category name
	 * @throws Exception the exception
	 */
	@Override
	public List<ExpenseDto> getAllExpenseByCategoryName(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Category> categories = categoryRepository.findByCategoryName(categoryName.toUpperCase());
			if (categories.isEmpty()) {
				return null;
			} else {

				List<ExpenseDto> list = new ArrayList<>();
				List<Expense> expenses =  categories.get(0).getExpenses();
				for (Expense x : expenses)
					list.add(ExpenseTransformer.getExpenseDto(x));

				return list;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ExpenseDto> getAllExpensAfterDate(Date after) {
		// TODO Auto-generated method stub
		try {
			List<ExpenseDto> list = new ArrayList<>();
			expenseRepository.findByDateAfter(after).forEach(expense -> list.add(ExpenseTransformer.getExpenseDto(expense)));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ExpenseDto> getAllExpensBeforeDate(Date before) {
		// TODO Auto-generated method stub
		try {
			List<ExpenseDto> list = new ArrayList<>();
			expenseRepository.findByDateBefore(before).forEach(expense -> list.add(ExpenseTransformer.getExpenseDto(expense)));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ExpenseDto> getAllExpensBetweenDate(Date after, Date before) {
		// TODO Auto-generated method stub
		try {
			List<ExpenseDto> list = new ArrayList<>();
			expenseRepository.findByDateBetween(after, before).forEach(expense -> list.add(ExpenseTransformer.getExpenseDto(expense)));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Double getTotalExpense() throws Exception {
		// TODO Auto-generated method stub
		return expenseRepository.totalExpense();
	}

	

}
