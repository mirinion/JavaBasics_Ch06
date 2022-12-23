package Ex20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex20 {
	/*
	Реализуйте следующий метод:
	@SafeVarargs public static final <T> T[] repeat(int n, T... objs)
	Он должен возвращать массив n копий заданных объектов.
	Имейте в виду, что для этого не потребуется объект типа Class или ссылка на конструктор,
	поскольку наращивать количество объектов objs можно рефлексивно.
	 */

	public static void main(String[] args) {
		Integer[] integers =  repeat(5, 1,2,3);

		System.out.println(Arrays.toString(integers));
	}


	@SafeVarargs
	public static final <T> T[] repeat(int n, T... objs) {
		List<T> resList = new ArrayList<>(n * objs.length);
		for (int i = 0; i < n; i++) {
			resList.addAll(Arrays.asList(objs));
		}
		return resList.toArray(objs);
	}

}
