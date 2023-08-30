
package com.xdev.jasperreportexample_v12.dal;

import com.xdev.jasperreportexample_v12.domain.Customer;
import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;


/**
 * Home object for domain model class Customer.
 * 
 * @see Customer
 */
public class CustomerDAO extends JpaDataAccessObject.Default<Customer, String>
{
	public final static CustomerDAO INSTANCE = new CustomerDAO();
	
	public CustomerDAO()
	{
		super(Customer.class);
	}
}
