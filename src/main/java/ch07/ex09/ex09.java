package ch07.ex09;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex09 {
	public static void main(String[] args) {
		try {
			ArrayList<String> wordsList = readWordsFromFile(Path.of("src/main/resources/source2.txt"));

			System.out.println(countWordsByContains(wordsList));
			System.out.println(countWordsByGetNull(wordsList));
			System.out.println(countWordsByGetOrDefault(wordsList));
			System.out.println(countByPutIfAbsent(wordsList));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Map<String, Integer> countWordsByContains(ArrayList<String> words) {
		Map<String, Integer> wordsCount = new HashMap<>();
		for(String word : words) {
			if (wordsCount.containsKey(word)) {
				wordsCount.put(word,
						wordsCount.get(word) + 1);
			} else {
				wordsCount.put(word, 1);
			}
		}
		return wordsCount;
	}

	private static Map<String, Integer> countWordsByGetNull(ArrayList<String> words) {
		Map<String, Integer> wordsCount = new HashMap<>();
		for (String word : words) {
			Integer count = wordsCount.get(word);
			if (count == null) {
				wordsCount.put(word, 1);
			} else {
				wordsCount.put(word, count + 1);
			}
		}
		return wordsCount;
	}

	private static Map<String, Integer>  countWordsByGetOrDefault(ArrayList<String> words) {
		Map<String, Integer> wordsCount = new HashMap<>();
		for (String word : words) {
			Integer count = wordsCount.getOrDefault(word, 0);
			wordsCount.put(word, count + 1);
		}
		return wordsCount;
	}

	private static Map<String, Integer> countByPutIfAbsent(ArrayList<String> words) {
		Map<String, Integer> wordsCount = new HashMap<>();
		for (String word : words) {
			Integer count = wordsCount.putIfAbsent(word, 1);
			if (count != null) {
				wordsCount.put(word, count + 1);
			}

		}
		return wordsCount;
	}

	private static ArrayList<String> readWordsFromFile(Path path)
			throws IOException {
		ArrayList<String> wordsArrayList = new ArrayList<>();
		try(Scanner in = new Scanner(path)) {
			while (in.hasNext()) {
				wordsArrayList.add(in.next());
			}
		} catch (IOException e) {
			throw e;
		}
		return wordsArrayList;
	}
}
