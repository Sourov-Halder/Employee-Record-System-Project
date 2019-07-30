package EmployeeRecordSystem;

@SuppressWarnings("serial")
public class HourlyEmployee extends Employee {

	double hourlyRate;
	int hourWorked;

	public HourlyEmployee(String name, String id, String designation, double hourlyRate, int hourWorked) {
		super(name, id, designation);
		this.hourlyRate = hourlyRate;
		this.hourWorked = hourWorked;
	}

	@Override
	void increaseSalary(double amt) {
		if (amt > 0) {
			hourlyRate += amt;
			System.out.println("Increased Successfully.");
		} else {
			System.out.println("Amount must be more than 0.");
		}
	}

	@Override
	double getSalary() {
		return (hourWorked * hourlyRate);
	}

	void display() {
		System.out.println(" Name: " + name + " | ID: " + id + " | Designation: " + designation + " | Salary: "
				+ (hourWorked * hourlyRate));
	}

	@Override
	public String toString() {
		return " Name: " + name + " | ID: " + id + " | Designation: " + designation + " | Salary: "
				+ (hourWorked * hourlyRate);
	}
}