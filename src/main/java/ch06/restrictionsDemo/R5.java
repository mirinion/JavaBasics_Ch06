package ch06.restrictionsDemo;

/**
 * Нельзя использовать параметры типа класса в статическом контексте
 * @param <T>
 */
public class R5<T> {
	public static void main(String[] args) {
		//T var; - cannot be referenced from a static context
	}

	//cannot be referenced from a static context
	//public static T foo() {}
}
