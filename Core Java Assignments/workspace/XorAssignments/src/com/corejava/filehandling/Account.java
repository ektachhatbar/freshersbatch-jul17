package com.corejava.filehandling;

import java.io.Serializable;

class Date implements Serializable{
	private static final long serialVersionUID = 4596395896503931430L;
	private int day;
	private int month;
	private int year;
	Date(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
}
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date dob;
	//transient private int accid;
	private int accid;

	Account(int accid,Date dob){
		this.accid=accid;
		this.dob=dob;
	}
	@Override
	public String toString() {
		return "Account [dob=" + dob + ", accid=" + accid + "]";
	}
	
}
