package com.odifn.core;

public class Employee {

	private String name;
	private String lastname;
	
	public Employee(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastname() {
		return lastname;
	}
}
