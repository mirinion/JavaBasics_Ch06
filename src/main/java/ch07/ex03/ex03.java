package ch07.ex03;

import java.util.HashSet;
import java.util.Set;

public class ex03 {
	public static void main(String[] args) {
		Set<String> stringSet1 = new HashSet<>();
		stringSet1.add("aaa");
		stringSet1.add("bbb");
		stringSet1.add("ccc");

		Set<String> stringSet2 = new HashSet<>();
		stringSet2.add("123");
		stringSet2.add("456");

		Set<String> stringSet3 = new HashSet<>();
		stringSet3.add("bbb");

		Set<String> stringSet4 = new HashSet<>();
		stringSet4.add("bbb");
		stringSet4.add("PPP");

		stringSet1.addAll(stringSet2); //Объединение
		System.out.println(stringSet1);

		stringSet1.retainAll(stringSet3); //Пересечение
		System.out.println(stringSet1);

		stringSet4.retainAll(stringSet3); //Разность
		System.out.println(stringSet4);


	}
}
