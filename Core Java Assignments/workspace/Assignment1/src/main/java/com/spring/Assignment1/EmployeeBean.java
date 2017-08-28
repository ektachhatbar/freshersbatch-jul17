package com.spring.Assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeBean {
	String empName;
	//@Autowired
	//@Qualifier("dept")
	DepartmentBean deptBean;
	public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeBean(String empName, DepartmentBean deptBean) {
		super();
		this.empName = empName;
		this.deptBean = deptBean;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public DepartmentBean getDeptBean() {
		return deptBean;
	}
	public void setDeptBean(DepartmentBean deptBean) {
		this.deptBean = deptBean;
	}
	
}
