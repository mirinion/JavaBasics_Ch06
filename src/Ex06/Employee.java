package Ex06;

public class Employee extends Person {
	protected double salary;

	public Employee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"salary=" + salary +
				", name='" + name + '\'' +
				'}';
	}

}
