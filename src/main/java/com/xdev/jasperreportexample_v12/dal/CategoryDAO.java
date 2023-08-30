
package com.xdev.jasperreportexample_v12.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.xdev.jasperreportexample_v12.domain.Category;


/**
 * Home object for domain model class Category.
 * 
 * @see Category
 */
public class CategoryDAO extends JpaDataAccessObject.Default<Category, Integer>
{
	public final static CategoryDAO INSTANCE = new CategoryDAO();
	
	public CategoryDAO()
	{
		super(Category.class);
	}
}
