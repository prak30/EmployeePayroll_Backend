package com.pranav.bl.employeepayroll.model;

public class EmployeeModel {
	public int id;
	public String name;
	public String gender;
	public int salary;
	public String department;
	public String address;

	public EmployeeModel() {
	}

	public EmployeeModel(String name, String gender, int salary, String department, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.department = department;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
