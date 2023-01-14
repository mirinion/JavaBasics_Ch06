package ch06;

public class Theory {
	/*
	Вариантность (ковариантность) - переменной типа ch06.Employee[] можно присвоить ch06.Manager[] (подкласс).
	(То есть массивы варианты -- значит если их элементы относятся как предок-наследник,
	то и массивы тоже)

	Списочные массивы ИНВАРИАНТНЫ - наследование не переносится с элементов на AL
	В ArrayList<ch06.Employee> нельзя записать ArrayList<ch06.Manager>:

	ArrayList<ch06.Manager> bosses = new ArrayList<>();
	ArrayList<ch06.Employee> empls = bosses; // Нельзя, но допустим, что можно ...
	empls.add(new ch06.Employee(...)); // Простой сотрудник среди начальства!

	Во многих случаях преобразование списочных массивов безопасно.
	Например, при ПОЛУЧИЕНИИ из него данных.
	Для указания порядка варьирования параметров или возвращаемого типа метода
	используют метасимволы подстановки подтипов:

	public static void printNames (ArrayList<? extends ch06.Employee> staff) {
		for (int i = 0; i < staff.size(); i++) {
			ch06.Employee e = staff.get(i);
			System.out.printIn(e.getName());
		}
	}

	Подстановочный тип ? extends ch06.Employee обозначает тип-подкласс ch06.Employee (или его самого)

	Но НЕЛЬЗЯ ДОБАВИТЬ элемент в списочный массив типа ArrayList <? extends ch06.Employee>
	Тк в противном случае можно было бы через метод add добавить ch06.Manager в
	ArrayList <Janitor>.
	 */

	/*
	Метасимвол подстановки супертипа
	? super ch06.Employee обозначает супертип для ch06.Employee.

	 */

	/*
	Стирание типа: во время компилиции НЕ создается отдельный класс для каждого типа, который использует дженерик
	Просто в обобщенном классе параметр типа заменяется на Object или на ограничение (суперкласс)
	 */

	public static void main(String[] args) {
		/*
		почему ковариантность массивов плохо, а инвариантность коллекций хорошо
	 	*/
		//Есть предупреждение, но сбой только во время выполнения (ArrayStoreException)

		Object[] objects = new Long[1];
		objects[0] = "Totally not a long...";

		//Не скомпилируется, тк Long хоть и наследник от Object,
		//но не их коллекции (инвариантность)
		//ArrayList<Object> objectArrayList = new ArrayList<Long>();
		//objectArrayList.add("String")
	}

	/*
	параметр типа в Class<T> нужен для метода T newInstance(), чтобы он возвращал T
	Это нужно чтобы не тратить ресурсы на приведение типов.
	Помимо newInstance в Class<T> есть еще несколько методов, где нужен параметр типа:
	Class<? super T> getSuperclass();
	<U> Class<? extends U> asSubclass<Class<U> clazz);
	...
	 */

}
