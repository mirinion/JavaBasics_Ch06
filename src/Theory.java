import java.util.ArrayList;

public class Theory {
	/*
	Вариантность (ковариантность) - переменной типа Employee[] можно присвоить Manager[] (подкласс).
	(То есть массивы варианты -- значит если их элементы относятся как предок-наследник,
	то и массивы тоже)

	Списочные массивы ИНВАРИАНТНЫ - наследование не переносится с элементов на AL
	В ArrayList<Employee> нельзя записать ArrayList<Manager>:

	ArrayList<Manager> bosses = new ArrayList();
	ArrayList<Employee> empls = bosses; // Нельзя, но допустим, что можно ...
	empls.add(new Employee(...)); // Простой сотрудник среди начальства!

	Во многих случаях преобразование списочных массивов безопасно.
	Например, при ПОЛУЧИЕНИИ из него данных.
	Для указания порядка варьирования параметров или возвращаемого типа метода
	используют метасимволы подстановки подтипов:

	public static void printNames (ArrayList<? extends Employee> staff) {
		for (int i = 0; i < staff.size(); i++) {
			Employee e = staff.get(i);
			System.out.printIn(e.getName());
		}
	}

	Подстановочный тип ? extends Employee обозначает тип-подкласс Employee (или его самого)

	Но НЕЛЬЗЯ ДОБАВИТЬ элемент в списочный массив типа ArrayList <? extends Employee>
	Тк в противном случае можно было бы через метод add добавить Manager в
	ArrayList <Janitor>.
	 */

	/*
	Метасимвол подстановки супертипа
	? super Employee обозначает супертип для Employee.

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

}
