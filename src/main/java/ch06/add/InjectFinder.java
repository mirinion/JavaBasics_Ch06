package ch06.add;


import com.google.common.reflect.TypeToken;
import org.apache.commons.lang3.reflect.TypeUtils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InjectFinder {
	public static List<Class<?>> list (Object o, String fieldName)
			throws InjectException, ClassLocationException {
		List<Class<?>> resultList = new ArrayList<>();
		Field field;
		Set<Class<?>> allClasses;

		try {
			field = o.getClass().getField(fieldName);
		} catch (NoSuchFieldException e) {
			throw new InjectException("This field doesn't exist", e);
		}

		allClasses = ClassLocator.findAllClasses();



		for(Class<?> clazz : allClasses) {
			TypeToken<?> fieldTypeToken = TypeToken.of(field.getType());
			if(fieldTypeToken.isSupertypeOf(clazz)) {
				resultList.add(clazz);
			}



		}

		return resultList;
	}

}
