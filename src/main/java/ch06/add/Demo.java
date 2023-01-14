package ch06.add;

import ch06.add.injectionExamples.InjectPoint;
import ch06.add.injectionExamples.InjectPointTemplate;
import ch06.add.injectionExamples.Pair;


public class Demo {
	public static void main(String[] args) {

		try {
			System.out.println(
					InjectFinder.list(new InjectPoint<>(), "field"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
