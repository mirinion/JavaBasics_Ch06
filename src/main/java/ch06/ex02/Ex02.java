package ch06.ex02;

public class Ex02 {
	public static void main(String[] args) {
		StackArrGeneric<String> stringGenStack = new StackArrGeneric<>(String[]::new, 3);
		StackArrObject<String> stringStackArrObject = new StackArrObject<>(String.class, 3);

		stringGenStack.push("H");
		stringGenStack.push("e");
		stringGenStack.push("l");
		stringGenStack.push("l");
		stringGenStack.push("o");

		stringStackArrObject.push("w");
		stringStackArrObject.push("o");
		stringStackArrObject.push("r");
		stringStackArrObject.push("l");
		stringStackArrObject.push("d");

		while (!stringStackArrObject.isEmpty()) {
			System.out.println(stringStackArrObject.pop());
		}

		while (!stringGenStack.isEmpty()) {
			System.out.println(stringGenStack.pop());
		}
	}
}
