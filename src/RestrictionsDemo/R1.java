package RestrictionsDemo;

/**
 * Запрет на аргументы примитивных типов
 */

/*
Поскольку в JVM при затирании все аргументы типа приводятся к Object,
а примитивы к Object привести нельзя (они от него не наследованы)
без упаковки в Integer
Решается использованием boxed
 */
public class R1 {
	public static void main(String[] args) {
		//ArrayList<int> Type argument cannot be of primitive type
		Object paramVar = (int)10;

		System.out.println(paramVar.getClass().getName()); //Integer
	}
}
