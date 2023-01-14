package ch07.ex05;

import java.util.*;

public class ex05 {
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<>();
		arrayList.add("aaa");
		arrayList.add("bbb");
		arrayList.add("ccc");

		List<String> linkedList = new LinkedList<>();
		linkedList.add("111");
		linkedList.add("222");
		linkedList.add("333");

		swap(arrayList, 0, 2);
		System.out.println(arrayList);

		swap(linkedList, 1, 2);
		System.out.println(linkedList);

		try {
			swap(arrayList, 10, -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void swap (List<?> list, int i, int j) {
		swapGeneric(list, i, j);
	}

	private static <T> void swapGeneric(List<T> list, int i, int j) {
		if (list instanceof RandomAccess) {
			T tmp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, tmp);
		} else {
			ListIterator<T> listIteratorI = list.listIterator(i);
			ListIterator<T> listIteratorJ = list.listIterator(j);
			T tmp = listIteratorI.next();
			listIteratorI.set(listIteratorJ.next());
			listIteratorJ.set(tmp);
		}

	}
}
