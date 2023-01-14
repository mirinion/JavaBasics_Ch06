package ch07.ex07;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex07 {
	public static void main(String[] args) {
		try {
			Map<String, Integer> wordsMap = countWordsInFile(
					Path.of("src/main/resources/source.txt"));
			System.out.println(wordsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Map<String, Integer> countWordsInFile (Path filePath)
			throws IOException {
		Map<String, Integer> countWordsMap = new TreeMap<>();

		try (Scanner in = new Scanner(filePath)) {
			while (in.hasNext()) {
				String word = in.next();
				countWordsMap.put(word,
						countWordsMap.getOrDefault(word, 0) + 1);
			}
		} catch (IOException e) {
			throw e;
		}

		return  countWordsMap;
	}
}
