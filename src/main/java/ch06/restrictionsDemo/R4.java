package ch06.restrictionsDemo;

import java.util.ArrayList;

/**
 * Нельзя построить массивы параметризованных типов
 */
public class R4 {
	public static void main(String[] args) {
		//Не скомпилируется: Generic array creation
		//Entry<Integer,String>[] entries = new Entry<Integer,String>[10];
		//Потому что после стирания будет Entry<Object,Object>
		//И без исключения ArrayStoreException в него можно было бы добавлять любые Entry

		Entry<Object,Object> entry = new Entry<>("a", 1);
		entry = new Entry<>(2, "b"); //Плохо, тк на выходе мб любой класс


		//Решается использованием списочных массивов
		ArrayList<Entry<Integer,String>> entryArrayList = new ArrayList<>();
		entryArrayList.add(0, new Entry<>(1, "a"));
		//entryArrayList.add(0, new Entry<>("b", 2)); - не скомпилируется
	}
}

class Entry<K,V> {
	private K key;
	private V value;
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
