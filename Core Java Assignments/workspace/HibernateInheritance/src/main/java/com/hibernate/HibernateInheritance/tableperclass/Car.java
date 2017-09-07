package com.hibernate.HibernateInheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="car")
public class Car extends Vehicle{
	@Column
	private String fourWheelSteering;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String name,double price,String fourWheelSteering) {
		super(name,price);
		this.fourWheelSteering = fourWheelSteering;
	}
	public String getFourWheelSteering() {
		return fourWheelSteering;
	}
	public void setFourWheelSteering(String fourWheelSteering) {
		this.fourWheelSteering = fourWheelSteering;
	}
	@Override
	public String toString() {
		return "Car [fourWheelSteering=" + fourWheelSteering + "]";
	}
}
