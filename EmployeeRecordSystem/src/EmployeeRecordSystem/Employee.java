package EmployeeRecordSystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {

	String name;
	String id;
	String designation;

	public Employee(String name, String id, String designation) {
		super();
		this.name = name;
		this.id = id;
		this.designation = designation;
	}

	void increaseSalary(double amt) {
		// Leave it empty.
	}

	double getSalary() {
		return 0;
	}

	void display() {
		System.out.println(" Name: " + name + " | ID: " + id + " | Designation: " + designation);
	}
}