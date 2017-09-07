package com.hibernate.HibernateInheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="bike")
public class Bike extends Vehicle{
	@Column
	private String twoWheelSteering;
	public Bike() {
		// TODO Auto-generated constructor stub
	}
	public Bike(String name,double price,String twoWheelSteering) {
		super(name,price);
		this.twoWheelSteering = twoWheelSteering;
	}
	public String getTwoWheelSteering() {
		return twoWheelSteering;
	}
	public void setTwoWheelSteering(String twoWheelSteering) {
		this.twoWheelSteering = twoWheelSteering;
	}
	@Override
	public String toString() {
		return "Bike [twoWheelSteering=" + twoWheelSteering + "]";
	}
	
	
}
