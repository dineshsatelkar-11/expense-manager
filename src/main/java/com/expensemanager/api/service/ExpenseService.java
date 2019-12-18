package com.expensemanager.api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensemanager.api.dao.ICategoryDao;
import com.expensemanager.api.dao.IExpenseDao;
import com.expensemanager.api.dto.ExpenseDto;
import com.expensemanager.api.model.Expense;


// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseService.
 */
@Service
public class ExpenseService implements IExpenseService {

	/** The expense dao. */
	@Autowired
	private IExpenseDao expenseDao;
	
	/**
	 * Gets the all expense.
	 *
	 * @return the all expense
	 * @throws Exception the exception
	 */
	@Override
	public List<ExpenseDto> getAllExpense() throws Exception  {
		// TODO Auto-generated method stub
		return expenseDao.getAllExpense();
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
		return expenseDao.addExpense(expenseDto);
	}

	@Override
	public List<ExpenseDto> getAllExpenseByCategoryName(String categoryName) throws Exception {
		// TODO Auto-generated method stub
		return expenseDao.getAllExpenseByCategoryName(categoryName);
	}

	@Override
	public List<ExpenseDto> getAllExpensAfterDate(Date after) {
		// TODO Auto-generated method stub
		return expenseDao.getAllExpensAfterDate(after);
	}

	@Override
	public List<ExpenseDto> getAllExpensBeforeDate(Date before) {
		// TODO Auto-generated method stub
		return expenseDao.getAllExpensBeforeDate(before);
	}

	@Override
	public List<ExpenseDto> getAllExpensBetweenDate(Date after, Date before) {
		// TODO Auto-generated method stub
		return expenseDao.getAllExpensBetweenDate(after,before);
	}

	@Override
	public Double getTotalExpense() throws Exception {
		// TODO Auto-generated method stub
		return expenseDao.getTotalExpense();
	}

}
