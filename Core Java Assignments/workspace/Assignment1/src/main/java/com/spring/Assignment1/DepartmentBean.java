package com.spring.Assignment1;

public class DepartmentBean {
	String deptName;
	
	public DepartmentBean() {
		// TODO Auto-generated constructor stub
	      System.out.println("Inside Department constructor." );

	}
	public DepartmentBean(String deptName) {
		super();
		this.deptName = deptName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
