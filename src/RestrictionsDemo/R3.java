package RestrictionsDemo;

import java.util.function.IntFunction;

/**
 * Нельзя получить экземпляры обобщенных типов
 */

/*
Происходит из-за стирания типов: "подобные формы запрещены тк они
не воплощают того чего хочет программист, когда стирается Т"

Обходится через передачу конструктора или рефлексию (newInstance метод)

 */
public class R3 {
	public static void main(String[] args) {

	}

	//Хотим на выходе получить n экземпляров obj в массив
	public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
		//T[] result = new T[n]; //нельзя!
		//Надо передать конструктор массива нужного типа

		T[] result = constr.apply(n);
		for (int i = 0; i < n; i++) {
			result[i] = obj;
		}

		return result;
	}

}
