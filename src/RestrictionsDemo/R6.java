package RestrictionsDemo;

/**
 * методы не должны конфликтовать после стирания
 */
public class R6 {
	
}


//interface Ordered<T> extends Comparable<T> {
//	default boolean equals(T value) {
//		// ОШИБКА: стирание типов приводит к конфликту с методом Object.equals()!
//		return compareTo(value) == 0;
//	}
//}

/*
Стирание здесь не происходит, но
конфликт возникает из-за мостовых методов.

Создаются мостовые методы:
1) В классе Employee int compareTo(Object other)
2) В классе Manager int compareTo(Object other)

Получается у manager две реализации compareTo
 */

class Employee implements Comparable<Employee> {
	String name;
	public int compareTo(Employee other) { return name.compareTo(other.name);
	}
}
//class Manager extends Employee implements Comparable<Manager> {
//	// ОШИБКА: две реализации интерфейса Comparable
//	// в качестве супертипов не разрешаются!
//
//	double salary;
//	public int compareTo(Manager other) {
//		return Double.compare(salary, other.salary);
//	}
//}
