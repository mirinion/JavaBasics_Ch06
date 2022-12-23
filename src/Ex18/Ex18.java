package Ex18;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Ex18 {
	/*
	public static <Т> Т[] repeat(int n, Т obj, IntFunction<T[]> constr)
	Почему исход вызова Arrays.repeat (10, 42, int[]::new) окажется неудачным?
	Как устранить этот недостаток? Что нужно сделать для применения других примитивных типов?
	 */

	public static void main(String[] args) {
		//repeat(10,42, int[]::new); - Нельзя из-за запрета на использование примитивов в аргументе типа
		System.out.println(
				Arrays.toString(repeat(10, 42, Integer[]::new))
		);  //Можно использовать boxed. Для других примитивов - другие функц интерфейсы

	}

	// Метод создает n копий переданного объекта obj в массиве
	public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
		T[] result = constr.apply(n);
		for (int i = 0; i < n; i++) result[i] = obj;
		return result;
	}

}
