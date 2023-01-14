package ch06.ex16;

public class Ex16 {
	/*
	К чему приведет стирание типов в приведенных ниже методах из класса
	Collection?
	 */

	/*
	public static <Т extends Comparable<? super Т>> void sort(List<T> list)
	преобразуется в
	public static void sort(List<Comparable> list)

	public static <T extends Object & Comparable<? super Т>> T max (Collection<? extends T> coll)
	преобразуется в
	public static Comparable<Object> max (Collection<Object> coll)
	 */
}
