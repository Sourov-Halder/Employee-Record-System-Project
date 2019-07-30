package EmployeeRecordSystem;

@SuppressWarnings("serial")
public class SalariedEmployee extends Employee {

	double monthlySalary;

	public SalariedEmployee(String name, String id, String designation, double monthlySalary) {
		super(name, id, designation);
		this.monthlySalary = monthlySalary;
	}

	@Override
	void increaseSalary(double amt) {
		if (amt > 0) {
			monthlySalary += amt;
			System.out.println("Increased Successfully.");
		} else {
			System.out.println("Amount must be more than 0.");
		}
	}

	@Override
	double getSalary() {
		return monthlySalary;
	}

	void display() {
		System.out.println(" Name: " + name + " | ID: " + id + " | Designation: " + designation + " | Salary: " + monthlySalary);
	}

	@Override
	public String toString() {
		return " Name: " + name + " | ID: " + id + " | Designation: " + designation + " | Salary: " + monthlySalary;
	}
}