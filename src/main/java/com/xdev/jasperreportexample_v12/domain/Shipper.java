
package com.xdev.jasperreportexample_v12.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import com.xdev.jasperreportexample_v12.dal.ShipperDAO;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Shipper
 */
@DAO(ShipperDAO.class)
@Caption("{%companyname}")
@Entity
@Cacheable(true)
@Table(name = "SHIPPERS", schema = "PUBLIC", catalog = "NORTHWIND")
public class Shipper implements java.io.Serializable
{
	
	private Integer    shipperid;
	private String     companyname;
	private String     phone;
	private Set<Order> orders = new HashSet<Order>(0);
	
	public Shipper()
	{
	}
	
	@Caption("Shipperid")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "SHIPPERID", unique = true, nullable = false, columnDefinition = "INTEGER")
	public Integer getShipperid()
	{
		return this.shipperid;
	}
	
	public void setShipperid(Integer shipperid)
	{
		this.shipperid = shipperid;
	}
	
	@Caption("Companyname")
	@Column(name = "COMPANYNAME", nullable = false, columnDefinition = "VARCHAR", length = 40)
	public String getCompanyname()
	{
		return this.companyname;
	}
	
	public void setCompanyname(String companyname)
	{
		this.companyname = companyname;
	}
	
	@Caption("Phone")
	@Column(name = "PHONE", columnDefinition = "VARCHAR", length = 24)
	public String getPhone()
	{
		return this.phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	@Caption("Orders")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipper")
	public Set<Order> getOrders()
	{
		return this.orders;
	}
	
	public void setOrders(Set<Order> orders)
	{
		this.orders = orders;
	}
	
}
