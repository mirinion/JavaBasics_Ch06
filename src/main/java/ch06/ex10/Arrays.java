package ch06.ex10;

import java.util.Comparator;
import java.util.List;

public class Arrays {

	//ch06.Ex10
	public static <E> E min(List<E> list, Comparator<? super E> comp) {
		E min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (comp.compare(min, list.get(i)) > 0)
				min = list.get(i);
		}
		return min;
	}

	//ch06.Ex10
	public static <E> E max(List<E> list, Comparator<? super E> comp) {
		E max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (comp.compare(max, list.get(i)) < 0)
				max = list.get(i);
		}
		return max;
	}

	//ch06.Ex12
	public static <T> void minmax(List<T> elements,
								  Comparator<? super T> comp,
								  List<? super T> result) {
		result.add(min(elements, comp));
		result.add(max(elements, comp));
	}
}
