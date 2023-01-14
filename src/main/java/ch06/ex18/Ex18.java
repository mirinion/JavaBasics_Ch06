package ch06.ex18;

public class Ex18 {
	/*
	public static <Т> Т[] repeat(int n, Т obj, IntFunction<T[]> constr)
	Почему исход вызова Arrays.repeat (10, 42, int[]::new) окажется неудачным?
	Как устранить этот недостаток? Что нужно сделать для применения других примитивных типов?
	 */

	public static void main(String[] args) {
		repeat(10,42, int[]::new);
 //Можно использовать boxed. Для других примитивов - другие функц интерфейсы

	}

	// Метод создает n копий переданного объекта obj в массиве
	public static int[] repeat(int n, int obj, ToIntArrFunction constr) {
		int[] result = constr.apply(n);
		for (int i = 0; i < n; i++) result[i] = obj;
		return result;
	}

}

@FunctionalInterface
interface ToIntArrFunction {
	int[] apply(int size);
}
