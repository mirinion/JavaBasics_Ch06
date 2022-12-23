import java.util.ArrayList;
import java.util.function.Predicate;


public class Pecs {
	public static void main(String[] args) {
		ArrayList<Manager> managers = new ArrayList<>();
		//ArrayList<Employee> employees = managers; - нельзя

		Manager[] manArr = new Manager[]{new Manager(1, 2), new Manager(2, 3)};

		producerFunc(managers); //Можно

		//Для менеджеров можно задать такой же предикат, как и для сотрудников
		//Например, по полю empField (оно у них тоже есть)
		Predicate<Employee> somePredicateForEmps = new Predicate<Employee>() {
			@Override
			public boolean test(Employee employee) {
				return employee.empField > 1;
			}
		};

		consumerFunc(manArr, somePredicateForEmps);
	}

	static void producerFunc(ArrayList<? extends Employee> empList) {
		for(Employee e : empList) {
			System.out.println(e.empField);
		}
	}

	public static void consumerFunc(Manager[] managers, Predicate<? super Manager> filter) {
		for (Manager m : managers) if (filter.test(m))
			System.out.println(m.toString());
	}
}

class Employee {
	int empField;

	public Employee(int empField) {
		this.empField = empField;
	}

	public int getEmpField() {
		return empField;
	}
}

class Manager extends Employee {
	int manField;

	public Manager(int empField, int manField) {
		super(empField);
		this.manField = manField;
	}

	public int getManField() {
		return manField;
	}

	@Override
	public String toString() {
		return "Manager{" +
				"manField=" + manField +
				", empField=" + empField +
				'}';
	}
}
