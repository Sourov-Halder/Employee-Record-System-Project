package EmployeeRecordSystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UapCSE implements Serializable {

	Employee[] employees = new Employee[1000];

	public void addNewEmployee(Employee e) {
		int i;
		for (i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				employees[i] = e;
				break;
			}
		}
	}

	public void addNewEmployee(String name, String id, String desig, double sal) {
		SalariedEmployee se = new SalariedEmployee(name, id, desig, sal);
		this.addNewEmployee(se);
	}

	public void addNewEmployee(String name, String id, String desig, double hr, int hw) {
		HourlyEmployee he = new HourlyEmployee(name, id, desig, hr, hw);
		this.addNewEmployee(he);
	}

	public void addNewEmployee(String name, String id, String desig, double com, double sale) {
		CommissionEmployee ce = new CommissionEmployee(name, id, desig, com, sale);
		this.addNewEmployee(ce);
	}

	@SuppressWarnings("unused")
	public Employee findEmployee(String id) {
		int i = 0;
		boolean found = false;
		try {
			for (i = 0; i < employees.length; i++) {
				if (employees[i] != null) {
					if (employees[i].id.equals(id)) {
						found = true;
						break;
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
			System.out.print("");
		}

		if (found = true) {
			return employees[i];
		} else {
			return null;
		}
	}

	public void increaseSalary(String id, double amt) {
		Employee em = findEmployee(id);
		if (em == null) {
			System.out.println("ID doesn't exist.");
		} else {
			em.increaseSalary(amt);
		}
	}

	public double getSalary(String id) {
		Employee em = findEmployee(id);
		if (em == null) {
			System.out.println("ID doesn't exist.");
			return 0;
		} else {
			return em.getSalary();
		}
	}

	public void display() {
		int i;
		for (i = 0; i < employees.length; i++) {
			if (employees[i] != null) {
				employees[i].display();
			} else {
				break;
			}
		}
	}
}