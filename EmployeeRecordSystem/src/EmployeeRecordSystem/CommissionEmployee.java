package EmployeeRecordSystem;

@SuppressWarnings("serial")
public class CommissionEmployee extends Employee {

	double commission;
	double sale;

	public CommissionEmployee(String name, String id, String designation, double comission, double sale) {
		super(name, id, designation);
		this.commission = comission;
		this.sale = sale;
	}

	@Override
	void increaseSalary(double amt) {
		if (amt > 0) {
			commission += amt;
			System.out.println("Increased Successfully.");
		} else {
			System.out.println("Amount must be more than 0.");
		}
	}

	@Override
	double getSalary() {
		return (commission * sale);
	}

	void display() {
		System.out.println(" Name: " + name + " | ID: " + id + " | Designation: " + designation + " | Salary: " + (commission * sale));
	}

	@Override
	public String toString() {
		return " Name: " + name + " | ID: " + id + " | Designation: " + designation + " | Salary: " + (commission * sale);
	}
}