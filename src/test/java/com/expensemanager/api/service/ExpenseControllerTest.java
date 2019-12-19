package com.expensemanager.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.expensemanager.api.controller.ExpenseServiceController;
import com.expensemanager.api.dao.ExpenseDao;
import com.expensemanager.api.dto.CategoryDto;
import com.expensemanager.api.dto.ExpenseDto;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ExpenseServiceController.class)
public class ExpenseControllerTest {

	private  ExpenseService mockUserService;
	private  ExpenseServiceController expenseController;
	
	@Test
	  public void testGetAllExpense() throws Exception {
		mockUserService = PowerMockito.mock(ExpenseService.class);
	    PowerMockito.when(mockUserService.getTotalExpense()).thenReturn(100D);
	    expenseController = new ExpenseServiceController(mockUserService);
	    
	    assertEquals(100d, expenseController.getExpense().doubleValue(),0.0);
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
	        mockUserService = PowerMockito.mock(ExpenseService.class);
	        PowerMockito.when(mockUserService.getAllExpense()).thenReturn(list);
	         
	        //test
	        List<ExpenseDto> empList = mockUserService.getAllExpense();
	         
	        assertEquals(3, empList.size());
	        verify(mockUserService, times(1)).getAllExpense();
	    }
}
