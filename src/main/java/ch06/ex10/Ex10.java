package ch06.ex10;


import ch06.ex06.Accountant;
import ch06.ex06.Employee;

import java.util.ArrayList;

public class Ex10 {
	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(10);
		integers.add(3);

		System.out.println(integers);
		System.out.println("max: " + Arrays.max(integers, Integer::compareTo));
		System.out.println("min: " + Arrays.min(integers, Integer::compareTo));

		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Igor", 100_000));
		employees.add(new Accountant("Olga", 120_000, 4));

		System.out.println(employees);
		System.out.println("Emp with max salary: " + Arrays.max(employees,
				(o1, o2) ->  (int)(o1.getSalary() - o2.getSalary())));
		System.out.println("Emp with min salary: " + Arrays.min(employees,
				(o1, o2) -> (int)(o1.getSalary() - o2.getSalary())));

	}
}
