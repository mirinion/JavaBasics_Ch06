package ch06.add;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassLocator {
	private static final Set<Class<?>> locatedClasses = new HashSet<>();

	public static Set<Class<?>> findAllClasses() throws ClassLocationException {
		String dir = getSourseDir(); //"/Users/emilsadykov/Desktop/Java/JavaBasics/target/classes/"

		File file = new File(dir);
		if (!file.isDirectory()) {
			throw new ClassLocationException("Invalid directory");
		}
		try {
			for (File f : Objects.requireNonNull(file.listFiles())) {
				scanDir(f, "");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("some classes not found");
		}
		return locatedClasses;
	}

	private static void scanDir(File file, String packageName) throws ClassNotFoundException {
		if (file.isDirectory()) {
			packageName += file.getName() + ".";
			for (File f : Objects.requireNonNull(file.listFiles())) {
				scanDir(f, packageName);
			}
		} else {
			if (!file.getName().endsWith(".class")) {
				return;
			}
			String className = packageName + file.getName().replace(".class", "");
			locatedClasses.add(Class.forName(className));
		}
	}

	private static String getSourseDir() {
		return ClassLocator.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	}
}
