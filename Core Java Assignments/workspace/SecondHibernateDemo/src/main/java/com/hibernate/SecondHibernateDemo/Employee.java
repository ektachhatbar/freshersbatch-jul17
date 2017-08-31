package com.hibernate.SecondHibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_MASTER")
@NamedQueries({
	@NamedQuery(name="getAllEmployees",query="from Employee")
})
public class Employee {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="EMPID")
	private long id;
	@Column(name="EMP_NAME")
	private String name;
	@Column(name="CITY")
	private String city;
	@Column(name="SALARY")
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	

	public Employee(String name, String city, double salary) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}
	
	
}
