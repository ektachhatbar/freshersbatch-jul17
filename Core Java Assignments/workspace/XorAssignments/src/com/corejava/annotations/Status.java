package com.corejava.annotations;

public enum Status {

	NEW(1), REJECTED(2), ACCEPTED(3), COMPLETED(4);
	int statusNo;

	private Status(int statusNo) {
		this.statusNo = statusNo;
	}
	
	public int getStatusNo(){
		
		return this.statusNo;
	}
}
