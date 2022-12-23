package Ex16;

public class Ex16 {
	/*
	К чему приведет стирание типов в приведенных ниже методах из класса
	Collection?
	 */

	/*
	public static <Т extends Comparable<? super Т>> void sort(List<T> list)
	преобразуется в
	public static void sort(List<Comparable> list)

	public static <T extends Object & Comparable<? super Т » T max (Collections extends T> coll)
	преобразуется в
	 */
}
