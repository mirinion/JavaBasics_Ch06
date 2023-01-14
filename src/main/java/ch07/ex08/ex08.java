package ch07.ex08;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ex08 {
	public static void main(String[] args) {
		try {
			System.out.println(getLinesWithAllWords(Path.of("src/main/resources/source2.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<String> readLinesFromFile(Path path)
			throws IOException {
		ArrayList<String> lines = new ArrayList<>();
		try (Scanner in = new Scanner(path)) {
			while (in.hasNext()) {
				lines.add(in.nextLine());
			}
		} catch (IOException e) {
			throw e;
		}
		return lines;
	}

	private static Map<String, Set<String>> mapLineToWordsSet(ArrayList<String> lines, Set<String> allWordsSet) {
		Map<String, Set<String>> lineToWords = new TreeMap<>();
		for (String line : lines) {
			List<String> wordsInLine = Arrays.asList(line.split(" "));
			allWordsSet.addAll(wordsInLine);
			lineToWords.computeIfAbsent(line,
					l -> new HashSet<>(wordsInLine));
		}
		return  lineToWords;
	}

	private static ArrayList<String> getLinesWithAllWords(Path path) throws IOException {
		ArrayList<String> allLines = readLinesFromFile(path);
		Set<String> allWords = new HashSet<>();
		Map<String, Set<String>> lineToWords = mapLineToWordsSet(allLines, allWords);

		ArrayList<String> allWordsLines = new ArrayList<>();
		int allWordsCardinality = allWords.size();
		for(Map.Entry<String, Set<String>> entry : lineToWords.entrySet()) {
			if (entry.getValue().size() == allWordsCardinality) {
				allWordsLines.add(entry.getKey());
			}
		}

		return allWordsLines;
	}

}
