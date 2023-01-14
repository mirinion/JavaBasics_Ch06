package ch06.ex08;

public class Ex08 {
	public static void main(String[] args) {
		Pair<Integer> integerPair = new Pair<>(10, 2);

		System.out.println("Max in pair: " + integerPair.max());
		System.out.println("Min in pair: " + integerPair.min());

		Pair<String> stringPair = new Pair<>("aaaa", "bbb");
		System.out.println("Max in pair: " + stringPair.max());
		System.out.println("Min in pair: " + stringPair.min());
	}


}
