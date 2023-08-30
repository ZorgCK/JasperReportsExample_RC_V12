
package com.xdev.jasperreportexample_v12.dal;

import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;
import com.xdev.jasperreportexample_v12.domain.Order;


/**
 * Home object for domain model class Order.
 * 
 * @see Order
 */
public class OrderDAO extends JpaDataAccessObject.Default<Order, Integer>
{
	public final static OrderDAO INSTANCE = new OrderDAO();
	
	public OrderDAO()
	{
		super(Order.class);
	}
}
