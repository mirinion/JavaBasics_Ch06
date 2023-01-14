package ch06.ex02;


import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArrObject<T> {
	private Object[] arr;
	private Class<T> clazz;
	private int count;
	private int capacity;

	public StackArrObject(Class<T> clazz, int capacity) {
		this.clazz = clazz;
		this.capacity = capacity;
		this.arr = new Object[capacity];
	}

	public void push(T value) {
		if (count == capacity) {
			expandArray();
		}
		arr[count++] = value;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Object value = arr[--count];
		return clazz.cast(value);

	}

	public boolean isEmpty() {
		return (count==0);
	}


	private void expandArray() {
		arr = Arrays.copyOf(arr, capacity * 2);
		capacity *= 2;
	}
}
