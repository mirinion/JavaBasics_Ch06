package RestrictionsDemo;

import java.util.ArrayList;

/**
 * Во время компиляции все классы оказываются базовыми
 */

/*
Поскольку при затирании все типы приводятся к Object или тому, что указано в e/s подстановке,
нельзя через instanseof проверить, например:

if(list instanceof ArrayList<String>)

при приведении также проверяется только проверка на соответсвтвие AL
 */
public class R2 {
	public static void main(String[] args) {
		Object source = new ArrayList<String>();
		((ArrayList<String>) source).add("It's a trap");
		//Unchecked cast: 'java.lang.Object' to 'java.util.ArrayList<java.lang.Integer>'

		//см загрязнение кучи
		ArrayList<Integer> integers = (ArrayList<Integer>) source;

		Integer myInteger = integers.get(0); //ClassCastException

	}
}
