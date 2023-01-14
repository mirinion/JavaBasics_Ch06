package ch07.ex11;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class Ex11  {
	public static void main(String[] args) {
		List<String> words = readWordsFromTerminal();
		shuffleWords(words);
		System.out.println(words);
	}

	public static void shuffleWords(List<String> words) {
		Collections.shuffle(words, new Random() {
			boolean isFirst = true;
			@Override
			public int nextInt(int bound) {
				if (isFirst) {
					isFirst = false;
					return words.size() - 1;
				}
				return super.nextInt(1, bound);
			}
		});
	}

	private static List<String> readWordsFromTerminal() {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		return Arrays.asList(
				sentence.split("\\s++")); //1 или неск пробелов
	}


}
