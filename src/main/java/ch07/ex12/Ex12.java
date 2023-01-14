package ch07.ex12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex12 {
	public static void main(String[] args) {
		List<String> words = readWordsFromTerminal();
		processWords(words);
		System.out.println(words);
	}

	public static void processWords(List<String> words) {
		firstLetterToLow(words);
		deleteDot(words);
		Collections.shuffle(words);
		firstLetterToHigh(words);
		putDot(words);
	}

	private static void firstLetterToLow(List<String> words) {
		words.set(0, Character.toLowerCase(words.get(0).charAt(0))
				+ words.get(0).substring(1)
		);
	}

	private static void firstLetterToHigh(List<String> words) {
		words.set(0, Character.toUpperCase(words.get(0).charAt(0))
				+ words.get(0).substring(1));
	}

	private static void deleteDot(List<String> words) {
		String lastWord = words.get(words.size()-1);
		if(lastWord.contains(".")) {
			words.set(words.size() - 1, lastWord.substring(0,lastWord.length()-1));
		}
	}

	private static void putDot(List<String> words) {
		String lastWord = words.get(words.size()-1);
		words.set(words.size()-1, lastWord + '.');
	}


	private static List<String> readWordsFromTerminal() {
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		return Arrays.asList(
				sentence.split("\\s++")); //1 или неск пробелов
	}
}
