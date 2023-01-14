package ch07.ex04;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Игорь");
		names.add("Степан");
		names.add("Сергей");
		names.add("Петр");

		try {
			exceptionRemoving(names, "Сергей");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(names);

		iteratorRemoving(names, "Степан");
		System.out.println(names);

		names.removeIf(s -> s.equals("Петр"));
		System.out.println(names);

	}

	public static void exceptionRemoving(List<String> list, String removingString) {
		for(String name : list) {
			if (name.equals(removingString)) {
				list.remove(removingString);
			}
		}
	}

	public static void iteratorRemoving(List<String> list, String removingString) {
		ListIterator<String> iterator = list.listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(removingString)) {
				iterator.remove();
			}
		}
	}

}
