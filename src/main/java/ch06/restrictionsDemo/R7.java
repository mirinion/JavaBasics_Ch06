package ch06.restrictionsDemo;

import java.nio.file.Files;

import java.nio.file.Path;
import java.util.concurrent.Callable;


/**
 * Объекты обобщенного класса нельзя геренировать или перехватывать.
 * Нельзя создать обобщенный класс в качестве подтипа Throwable
 */

public class R7 {
	public static void main(String[] args) {
		readAll(Path.of("C:/"));
		System.out.println("next...");
	}

	public static String readAll(Path path) {
		//несмотря на то что в doWork генерируется проверяемое NoSuchFileException
		//оно не отлавливается (его не видно)
		return Exceptions.doWork(() -> new String(Files.readAllBytes(path)));
	}
}

//public static <Т extends Throwable> void doWork(Runnable r, Class<T> cl) {
//	try {
//		r.run();
//	} catch (T ex) { // ОШИБКА: перехватить переменную типа нельзя!
//		Logger.getGlobal().log(..., ..., ex);
//	}
//}

/*
Сделано это тк обобщения позволяли бы стирать разницу между проверяемыми
и непроверяемыми исключениями.
 */

class Exceptions {
	@SuppressWarnings("unchecked")
	private static <T extends Throwable> void throwAs(Throwable e) throws T {
		throw (T) e; // Приведение обобщенного типа стирается в тип (Throwable) е
	}
	public static <V> V doWork(Callable<V> c) {
		try {
			return c.call();
		} catch (Throwable ex) {
			Exceptions.<RuntimeException>throwAs(ex);
			return null;
		}
	}
}
