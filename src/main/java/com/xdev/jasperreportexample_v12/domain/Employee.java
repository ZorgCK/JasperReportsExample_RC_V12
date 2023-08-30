
package com.xdev.jasperreportexample_v12.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.rapidclipse.framework.server.data.DAO;
import com.rapidclipse.framework.server.resources.Caption;
import com.xdev.jasperreportexample_v12.dal.EmployeeDAO;


/**
 * Employee
 */
@DAO(EmployeeDAO.class)
@Caption("{%lastname}")
@Entity
@Cacheable(true)
@Table(name = "EMPLOYEES", schema = "PUBLIC", catalog = "NORTHWIND")
public class Employee implements java.io.Serializable
{
	
	private Integer                                               employeeid;
	private com.xdev.jasperreportexample_v12.domain.Employee      employee;
	private String                                                lastname;
	private String                                                firstname;
	private String                                                title;
	private String                                                titleofcourtesy;
	private Date                                                  birthdate;
	private Date                                                  hiredate;
	private String                                                address;
	private String                                                city;
	private String                                                region;
	private String                                                postalcode;
	private String                                                country;
	private String                                                homephone;
	private String                                                extension;
	private byte[]                                                photo;
	private String                                                notes;
	private String                                                photopath;
	private Double                                                salary;
	private Set<Territory>                                        territories = new HashSet<>(0);
	private Set<Order>                                            orders      = new HashSet<>(0);
	private Set<com.xdev.jasperreportexample_v12.domain.Employee> employees   =
		new HashSet<>(0);
	private ByteArrayInputStream                                  photoStream;
	
	public Employee()
	{
	}
	
	@Caption("Employeeid")
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "EMPLOYEEID", unique = true, nullable = false, columnDefinition = "INTEGER")
	public Integer getEmployeeid()
	{
		return this.employeeid;
	}
	
	public void setEmployeeid(final Integer employeeid)
	{
		this.employeeid = employeeid;
	}
	
	@Caption("Employee")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REPORTSTO", columnDefinition = "INTEGER")
	public com.xdev.jasperreportexample_v12.domain.Employee getEmployee()
	{
		return this.employee;
	}
	
	public void setEmployee(final com.xdev.jasperreportexample_v12.domain.Employee employee)
	{
		this.employee = employee;
	}
	
	@Caption("Lastname")
	@Column(name = "LASTNAME", nullable = false, columnDefinition = "VARCHAR", length = 20)
	public String getLastname()
	{
		return this.lastname;
	}
	
	public void setLastname(final String lastname)
	{
		this.lastname = lastname;
	}
	
	@Caption("Firstname")
	@Column(name = "FIRSTNAME", nullable = false, columnDefinition = "VARCHAR", length = 10)
	public String getFirstname()
	{
		return this.firstname;
	}
	
	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}
	
	@Caption("Title")
	@Column(name = "TITLE", columnDefinition = "VARCHAR", length = 30)
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}
	
	@Caption("Titleofcourtesy")
	@Column(name = "TITLEOFCOURTESY", columnDefinition = "VARCHAR", length = 25)
	public String getTitleofcourtesy()
	{
		return this.titleofcourtesy;
	}
	
	public void setTitleofcourtesy(final String titleofcourtesy)
	{
		this.titleofcourtesy = titleofcourtesy;
	}
	
	@Caption("Birthdate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDATE", columnDefinition = "TIMESTAMP", length = 26)
	public Date getBirthdate()
	{
		return this.birthdate;
	}
	
	public void setBirthdate(final Date birthdate)
	{
		this.birthdate = birthdate;
	}
	
	@Caption("Hiredate")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HIREDATE", columnDefinition = "TIMESTAMP", length = 26)
	public Date getHiredate()
	{
		return this.hiredate;
	}
	
	public void setHiredate(final Date hiredate)
	{
		this.hiredate = hiredate;
	}
	
	@Caption("Address")
	@Column(name = "ADDRESS", columnDefinition = "VARCHAR", length = 60)
	public String getAddress()
	{
		return this.address;
	}
	
	public void setAddress(final String address)
	{
		this.address = address;
	}
	
	@Caption("City")
	@Column(name = "CITY", columnDefinition = "VARCHAR", length = 15)
	public String getCity()
	{
		return this.city;
	}
	
	public void setCity(final String city)
	{
		this.city = city;
	}
	
	@Caption("Region")
	@Column(name = "REGION", columnDefinition = "VARCHAR", length = 15)
	public String getRegion()
	{
		return this.region;
	}
	
	public void setRegion(final String region)
	{
		this.region = region;
	}
	
	@Caption("Postalcode")
	@Column(name = "POSTALCODE", columnDefinition = "VARCHAR", length = 10)
	public String getPostalcode()
	{
		return this.postalcode;
	}
	
	public void setPostalcode(final String postalcode)
	{
		this.postalcode = postalcode;
	}
	
	@Caption("Country")
	@Column(name = "COUNTRY", columnDefinition = "VARCHAR", length = 15)
	public String getCountry()
	{
		return this.country;
	}
	
	public void setCountry(final String country)
	{
		this.country = country;
	}
	
	@Caption("Homephone")
	@Column(name = "HOMEPHONE", columnDefinition = "VARCHAR", length = 24)
	public String getHomephone()
	{
		return this.homephone;
	}
	
	public void setHomephone(final String homephone)
	{
		this.homephone = homephone;
	}
	
	@Caption("Extension")
	@Column(name = "EXTENSION", columnDefinition = "VARCHAR", length = 4)
	public String getExtension()
	{
		return this.extension;
	}
	
	public void setExtension(final String extension)
	{
		this.extension = extension;
	}
	
	@Caption("Photo")
	@Lob
	@Column(name = "PHOTO", columnDefinition = "BLOB")
	public byte[] getPhoto()
	{
		return this.photo;
	}
	
	public void setPhoto(final byte[] photo)
	{
		this.photo = photo;
	}
	
	@Caption("Notes")
	@Lob
	@Column(name = "NOTES", nullable = false, columnDefinition = "CLOB")
	public String getNotes()
	{
		return this.notes;
	}
	
	public void setNotes(final String notes)
	{
		this.notes = notes;
	}
	
	@Caption("Photopath")
	@Column(name = "PHOTOPATH", columnDefinition = "VARCHAR")
	public String getPhotopath()
	{
		return this.photopath;
	}
	
	public void setPhotopath(final String photopath)
	{
		this.photopath = photopath;
	}
	
	@Caption("Salary")
	@Column(name = "SALARY", columnDefinition = "DOUBLE", precision = 17, scale = 0)
	public Double getSalary()
	{
		return this.salary;
	}
	
	public void setSalary(final Double salary)
	{
		this.salary = salary;
	}
	
	@Caption("Territories")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EMPLOYEETERRITORIES", schema = "PUBLIC", catalog = "NORTHWIND", joinColumns = {
		@JoinColumn(name = "EMPLOYEEID", nullable = false, updatable = false, columnDefinition = "INTEGER")}, inverseJoinColumns = {
			@JoinColumn(name = "TERRITORYID", nullable = false, updatable = false, columnDefinition = "VARCHAR")})
	public Set<Territory> getTerritories()
	{
		return this.territories;
	}
	
	public void setTerritories(final Set<Territory> territories)
	{
		this.territories = territories;
	}
	
	@Caption("Orders")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Order> getOrders()
	{
		return this.orders;
	}
	
	public void setOrders(final Set<Order> orders)
	{
		this.orders = orders;
	}
	
	@Caption("Employees")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<com.xdev.jasperreportexample_v12.domain.Employee> getEmployees()
	{
		return this.employees;
	}
	
	public void setEmployees(final Set<com.xdev.jasperreportexample_v12.domain.Employee> employees)
	{
		this.employees = employees;
	}
	
	@Transient
	@Column(name = "PHOTOSTREAM")
	public ByteArrayInputStream getPhotoStream()
	{
		final ByteArrayInputStream stream = new ByteArrayInputStream(this.photo);
		return stream;
	}

	public void setPhotoStream(final ByteArrayInputStream noname)
	{
		this.photoStream = noname;
	}
}
