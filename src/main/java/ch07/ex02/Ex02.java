package ch07.ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex02 {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();

		strings.add("123_! ы");
		strings.add("abcd");
		strings.add("EfG hI");

		//toUpperListByIterator(strings);
		toUpperListByIndex(strings);
		//toUpperListByIterator(strings);

		System.out.println(strings);
	}

	public static void toUpperListByIterator(List<String> strings) {
		ListIterator<String> listIterator = strings.listIterator();

		while (listIterator.hasNext()) {
			listIterator.set((listIterator.next()).toUpperCase());
		}
	}

	public static void toUpperListByIndex(List<String> strings) {
		for (int i = 0; i < strings.size(); i++) {
			strings.set(i, strings.get(i).toUpperCase());
		}
	}

	public static void toUpperListByReplaceAll(List<String> strings) {
		strings.replaceAll(String::toUpperCase);
	}
}
