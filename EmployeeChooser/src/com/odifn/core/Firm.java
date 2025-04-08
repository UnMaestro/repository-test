package com.odifn.core;

import java.util.ArrayList;
import java.util.List;

public class Firm {

	private String firmName;
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	public Firm() {
		
	}
	
	public Firm(String firmName, Employee[] Employees) {
		this.firmName = firmName;
		for (Employee employee : Employees) {
			employeeList.add(employee);
		}
	}
	
	public String getName() {
		return firmName;
	}
	
	public Employee getEmployee(int index) {
		return employeeList.get(index);
	}
	
	public int getTotalEmployees() {
		return employeeList.size() - 1;
	}
	
	public void addEmployee(Employee emyployee) {
		employeeList.add(emyployee);
	}
	
}
