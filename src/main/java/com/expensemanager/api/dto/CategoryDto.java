package com.expensemanager.api.dto;

import java.sql.Date;
import java.util.Set;

import com.expensemanager.api.model.Category;
import com.expensemanager.api.model.Expense;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryDto.
 */
@Getter
@Setter
public class CategoryDto {

	/** The category name. */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
	private String categoryName;

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
