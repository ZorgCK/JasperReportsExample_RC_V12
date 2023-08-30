
package com.xdev.jasperreportexample_v12.dal;

import com.xdev.jasperreportexample_v12.domain.Territory;
import com.rapidclipse.framework.server.jpa.dal.JpaDataAccessObject;


/**
 * Home object for domain model class Territory.
 * 
 * @see Territory
 */
public class TerritoryDAO extends JpaDataAccessObject.Default<Territory, String>
{
	public final static TerritoryDAO INSTANCE = new TerritoryDAO();
	
	public TerritoryDAO()
	{
		super(Territory.class);
	}
}
