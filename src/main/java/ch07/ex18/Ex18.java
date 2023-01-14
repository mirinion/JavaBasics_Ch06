package ch07.ex18;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex18 {
	public static void main(String[] args) {
		//получаемые коллекции immutable

		//константы не параметризованы
		List emptyList = Collections.EMPTY_LIST;
		Map emptyMap = Collections.EMPTY_MAP;
		Set emptySet = Collections.EMPTY_SET;

		//методы параметризованы
		List<Integer> integerList = Collections.emptyList();
		Map<Integer, String> integerStringMap = Collections.emptyMap();
		Set<String> stringSet = Collections.emptySet();


		/*
		public static final <T> List<T> emptyList() {
        	return (List<T>) EMPTY_LIST;
    	}
		 */


	}
}
