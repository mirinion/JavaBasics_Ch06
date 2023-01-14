package ch07.ex17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ex17 {
	public static void main(String[] args) {
		try {
			ArrayList<String> stringArrayList = new ArrayList<>();
			List checked = Collections.checkedList(stringArrayList, String.class);
			checked.add(10);
		} catch (Exception e) {
			e.printStackTrace(); //ClassCastException
		}

	}

	/*
	класс CheckedCollection вложен в Collection

	Returns a dynamically typesafe view of the specified collection.
	Any attempt to insert an element of the wrong type will result in an immediate ClassCastException.
	The generics mechanism in the language provides compile-time (static) type checking,
	but it is possible to defeat this mechanism with unchecked casts.

	public boolean add(E e)   { return c.add(typeCheck(e)); }

	E typeCheck(Object o) {
            if (o != null && !type.isInstance(o))
                throw new ClassCastException(badElementMsg(o));
            return (E) o;
        }

        private String badElementMsg(Object o) {
            return "Attempt to insert " + o.getClass() +
                " element into collection with element type " + type;
        }
	 */
}
