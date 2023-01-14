package ch07.ex14_15_16;

import ch07.ex13.Cache;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

public class Ex14_15_16 {
	public static void main(String[] args) {

		//Ex14 demo
		//----------------------------------------------------------------------
		List<Integer> view1 = getViewNumsSerialInclusive(0, 100);
		try {
			System.out.println(view1.get(1));
			System.out.println(view1.get(10));
			//System.out.println(view.get(101)); //ArrayIndexOutOfBoundsException

			view1.set(0, 101); //Caution: Immutable object is modified
			// Throws UnsupportedOperationException
		} catch (Exception e) {
			e.printStackTrace();
		}
		//----------------------------------------------------------------------

		//Ex15, Ex16 demo
		//----------------------------------------------------------------------
		List<Integer> view2 = getViewNumsSerialInclusive(i -> i*i);
		try {
			System.out.println(view2.get(2));
			System.out.println(view2.get(10));
			System.out.println(view2.get(101));

			view2.set(1, 99); // Throws UnsupportedOperationException
		} catch (Exception e) {
			e.printStackTrace();
		}
		//----------------------------------------------------------------------

	}

	public static List<Integer> getViewNumsSerialInclusive(int from, int to) {
		return Collections.unmodifiableList(new AbstractList<>() {
			@Override
			public Integer get(int index) {
				if (index >= from && index <= to) {
					return index;
				} else {
					throw new ArrayIndexOutOfBoundsException();
				}
			}

			@Override
			public int size() {
				throw new UnsupportedOperationException();
			}
		});
	}

	//Ex 15, 16
	public static List<Integer> getViewNumsSerialInclusive(IntFunction<Integer> func) {
		Cache<Integer, Integer> cache = new Cache<>(100); //последние 100 знач вычесленных функцией

		return Collections.unmodifiableList(new AbstractList<>() {
			@Override
			public Integer get(int index) {
				if (cache.containsKey(index)) {
					return cache.get(index);
				} else {
					Integer res = func.apply(index);
					cache.put(index,res);
					return res;
				}
			}

			@Override
			public int size() {
				throw new UnsupportedOperationException();
			}

			@Override
			public Object[] toArray() {
				throw new UnsupportedOperationException();
			}
		});



	}
}
