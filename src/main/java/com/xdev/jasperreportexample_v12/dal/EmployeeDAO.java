
package com.xdev.jasperreportexample_v12.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.xdev.jasperreportexample_v12.domain.Employee;


/**
 * Home object for domain model class Employee.
 * 
 * @see Employee
 */
public class EmployeeDAO extends JpaDataAccessObject.Default<Employee, Integer>
{
	public final static EmployeeDAO INSTANCE = new EmployeeDAO();
	
	public EmployeeDAO()
	{
		super(Employee.class);
	}
}
