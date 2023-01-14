package ch06.ex12;

import ch06.ex06.Accountant;
import ch06.ex06.Employee;
import ch06.ex10.Arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class Ex12 {
	public static void main(String[] args) {
		ArrayList<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Denis", 100_000));
		emps.add(new Employee("Petr", 120_000));
		emps.add(new Employee("Elena", 110_000));
		emps.add(new Accountant("Alena", 150_000, 5));

		System.out.println(emps);

		ArrayList<Employee> minmaxSalary = new ArrayList<>();
		Arrays.minmax(emps,
				(e1, e2) -> (int)(e1.getSalary() - e2.getSalary()),
				minmaxSalary);

		System.out.println("Emps with min and max salary: " + minmaxSalary);

		ArrayList<Employee> minmaxNameLex = new ArrayList<>();
		Arrays.minmax(emps,
				Comparator.comparing(Employee::getName),
				minmaxNameLex);

		System.out.println("Emps with min and max name in lex. order: " + minmaxNameLex);
	}
}
