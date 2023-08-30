
package com.xdev.jasperreportexample_v12.domain;

import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import com.xdev.jasperreportexample_v12.dal.RegionDAO;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Region
 */
@DAO(RegionDAO.class)
@Caption("{%regiondescription}")
@Entity
@Cacheable(true)
@Table(name = "REGION", schema = "PUBLIC", catalog = "NORTHWIND")
public class Region implements java.io.Serializable
{
	
	private int            regionid;
	private String         regiondescription;
	private Set<Territory> territories = new HashSet<Territory>(0);
	
	public Region()
	{
	}
	
	@Caption("Regionid")
	@Id
	
	@Column(name = "REGIONID", unique = true, nullable = false, columnDefinition = "INTEGER")
	public int getRegionid()
	{
		return this.regionid;
	}
	
	public void setRegionid(int regionid)
	{
		this.regionid = regionid;
	}
	
	@Caption("Regiondescription")
	@Column(name = "REGIONDESCRIPTION", nullable = false, columnDefinition = "VARCHAR", length = 50)
	public String getRegiondescription()
	{
		return this.regiondescription;
	}
	
	public void setRegiondescription(String regiondescription)
	{
		this.regiondescription = regiondescription;
	}
	
	@Caption("Territories")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
	public Set<Territory> getTerritories()
	{
		return this.territories;
	}
	
	public void setTerritories(Set<Territory> territories)
	{
		this.territories = territories;
	}
	
}
