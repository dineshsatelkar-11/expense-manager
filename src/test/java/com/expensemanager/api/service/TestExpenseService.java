package com.expensemanager.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.expensemanager.api.dao.ExpenseDao;
import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.dto.ExpenseDto;

@RunWith(MockitoJUnitRunner.class)
public class TestExpenseService {

	@InjectMocks
	ExpenseService expenseService;
     
    @Mock
    ExpenseDao expenseDao;
    
    @Before(value = "")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getAllExpenseTest() throws Exception
    {
        List<ExpenseDto> list = new ArrayList<ExpenseDto>();
        
        CategoryDto category=new CategoryDto("Mobile");
        Date myDate = new Date(2019, 02, 12);
        ExpenseDto expOne = new ExpenseDto("Dinesh", "", 1000,myDate,category);
        ExpenseDto expTwo = new ExpenseDto( "Akshay", "", 200,myDate,category);
        ExpenseDto expThree = new ExpenseDto( "Sanket", "", 300,myDate,category);
         
        list.add(expOne);
        list.add(expTwo);
        list.add(expThree);
         
        when(expenseDao.getAllExpense()).thenReturn(list);
         
        //test
        List<ExpenseDto> empList = expenseService.getAllExpense();
         
        assertEquals(3, empList.size());
        verify(expenseDao, times(1)).getAllExpense();
    }
    
    @Test
    public void getAllExpensAfterDateTest()
    {
    	 Date myDate = new Date(2019, 02, 12);
    	 Date myDate1 = new Date(2019, 02, 10);
    	 CategoryDto category=new CategoryDto("Mobile");
    	 List<ExpenseDto> list = new ArrayList<ExpenseDto>();
    	 ExpenseDto expOne = new ExpenseDto("Dinesh", "", 1000,myDate,category);
         ExpenseDto expTwo = new ExpenseDto( "Akshay", "", 200,myDate,category);
         ExpenseDto expThree = new ExpenseDto( "Sanket", "", 300,myDate,category);
          
         list.add(expOne);
         list.add(expTwo);
         list.add(expThree);
         when(expenseDao.getAllExpensAfterDate(myDate1)).thenReturn(list);
           
        List<ExpenseDto> emp = expenseService.getAllExpensAfterDate(myDate1);
         
        assertEquals(3, emp.size());
       
    }
}
