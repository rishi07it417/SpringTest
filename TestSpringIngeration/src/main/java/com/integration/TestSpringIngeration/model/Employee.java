package com.integration.TestSpringIngeration.model;

public class Employee {
	private int id;
	private String name;
	private String deparatment;
	private String company;
	public Employee(int id, String name, String deparatment, String company) {
		super();
		this.id = id;
		this.name = name;
		this.deparatment = deparatment;
		this.company = company;
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
	public String getDeparatment() {
		return deparatment;
	}
	public void setDeparatment(String deparatment) {
		this.deparatment = deparatment;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deparatment=" + deparatment + ", company=" + company + "]";
	}
	
	
}
