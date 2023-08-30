
package com.xdev.jasperreportexample_v12.domain.queryObjects;

import java.math.BigDecimal;

import com.xdev.jasperreportexample_v12.domain.Category;


public class ProductCategorySum
{
	
	private BigDecimal priceOerCategory;
	private Category   category;
	
	public ProductCategorySum(final BigDecimal priceOerCategory, final Category category)
	{
		super();
		this.priceOerCategory = priceOerCategory;
		this.category         = category;
	}
	
	public BigDecimal getPriceOerCategory()
	{
		return this.priceOerCategory;
	}
	
	public void setPriceOerCategory(final BigDecimal priceOerCategory)
	{
		this.priceOerCategory = priceOerCategory;
	}
	
	public Category getCategory()
	{
		return this.category;
	}
	
	public void setCategory(final Category category)
	{
		this.category = category;
	}
	
}
