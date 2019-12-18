package com.expensemanager.api.dto;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.expensemanager.api.model.Category;
import com.expensemanager.api.model.Expense;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseDto.
 */
@Getter
@Setter
public class ExpenseDto {

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The amount. */
	private double amount;

	/** The date. */
	private Date date;

	/** The category dto. */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CategoryDto category;

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public CategoryDto getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public ExpenseDto(String title, String description, double amount, Date date, CategoryDto category) {
		super();
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.category = category;
	}

	public ExpenseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
