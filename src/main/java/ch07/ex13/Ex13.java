package ch07.ex13;

public class Ex13 {
	public static void main(String[] args) {
		Cache<Integer,String> cache = new Cache<>(3);

		cache.put(1, "One");
		cache.put(2, "Two");
		cache.put(3, "Three");
		cache.put(4, "Four");

		System.out.println(cache); //удалит первый элемент One
	}


}
