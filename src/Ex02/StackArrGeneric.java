package Ex02;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.function.IntFunction;

public class StackArrGeneric<E> {
	private E[] arr;
	private int count;
	private int capacity;

	public StackArrGeneric(IntFunction<E[]> constr, int capacity) {
		this.arr = constr.apply(capacity);
		this.capacity = capacity;
	}

	public void push (E value) {
		if (count == capacity) {
			expandArray();
		}
		arr[count++] = value;
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		return arr[--count];
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	private void expandArray() {
		arr = Arrays.copyOf(arr, capacity * 2);
		capacity *= 2;
	}
}
