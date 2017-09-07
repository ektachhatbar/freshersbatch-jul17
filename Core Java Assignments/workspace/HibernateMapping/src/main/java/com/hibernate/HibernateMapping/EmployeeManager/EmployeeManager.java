package com.hibernate.HibernateMapping.EmployeeManager;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_HQL")
public class EmployeeManager {
	@Id
	@GeneratedValue
	@Column(name="eid")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="manager_id")
	private EmployeeManager employee;
	
	public EmployeeManager() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeManager(String name) {
		super();
		this.name = name;
	}

	public EmployeeManager(String name, EmployeeManager employee) {
		super();
		this.name = name;
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeManager getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeManager employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		
		return "Employee [id=" + id + ", name=" + name + ", employee=" + employee + "]";

	}
	
}
