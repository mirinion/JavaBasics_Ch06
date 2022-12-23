package Ex06;

import java.util.ArrayList;

public class Ex06 {
	public static void main(String[] args) {
		ArrayList<Accountant> accountants = new ArrayList<>();
		ArrayList<Employee> employees = new ArrayList<>();
		ArrayList<Person> people = new ArrayList<>();

		accountants.add(new Accountant("Irina", 120_000, 5));

		employees.add(new Employee("Denis", 70_000));
		employees.add(new Employee("Boris", 90_000));

		people.add(new Person("Alina"));

		//Добавим бухгалтеров в общий список сотрудников
		//Бухгалтеры тоже сотрудники (Acc extends Emp)
		unionListsExt(employees, accountants);
		System.out.println("Employees after union");
		System.out.println(employees);

		//Добавим сотрудников (включая бухгалтеров) в общий список людей
		unionListsSup(people, employees);
		System.out.println("People after union");
		System.out.println(people);

		//Но нельзя добавить список сотрудников в список бухгалтеров
		//Так как сотрудники не имеют скиллов в 1С
		//unionListsSup(accountants, employees); - нельзя
	}

	public static <E> void unionListsExt (ArrayList<E> headList, ArrayList<? extends E> tailList) {
		headList.addAll(tailList);
	}

	public static <E> void unionListsSup (ArrayList<? super E> headList, ArrayList<E> tailList) {
		headList.addAll(tailList);
	}
}
