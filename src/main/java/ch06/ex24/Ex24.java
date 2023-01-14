package ch06.ex24;

public class Ex24 {
	/*
	Какие методы можно вызвать для переменной типа Class<?>, не прибегая к приведению типов?
	 */

	public static void main(String[] args) {
		foo(String.class);
	}

	public static void foo(Class<?> cl) {
		//cl.cast(object);
		System.out.println(cl.getName());
		System.out.println(cl.getComponentType());
		System.out.println(cl.toString());
		System.out.println(cl.arrayType());
		System.out.println(cl.asSubclass(Object.class));
		System.out.println(cl.getFields());
	}
}
