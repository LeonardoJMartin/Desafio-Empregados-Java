package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private int payDay;
	
	private Address address;
	private List<Employee> list = new ArrayList<>();
	
	public Department(String name, int payDay, Address address) {
		this.name = name;
		this.payDay = payDay;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPayDay() {
		return payDay;
	}

	public void setPayDay(int payDay) {
		this.payDay = payDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Employee> getList() {
		return list;
	}

	public void addEmployee(Employee employee) {
		list.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		list.remove(employee);
	}
	
	public double payroll() {
		double sum = 0;
		for(Employee x : list) {
			sum+= x.getSalary();
		}
		return sum;
	}
	
}
