
package com.xdev.jasperreportexample_v12.dal;

import com.xdev.jasperreportexample_v12.domain.Orderdetail;
import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.xdev.jasperreportexample_v12.domain.OrderdetailId;


/**
 * Home object for domain model class Orderdetail.
 * 
 * @see Orderdetail
 */
public class OrderdetailDAO extends JpaDataAccessObject.Default<Orderdetail, OrderdetailId>
{
	public final static OrderdetailDAO INSTANCE = new OrderdetailDAO();
	
	public OrderdetailDAO()
	{
		super(Orderdetail.class);
	}
}
