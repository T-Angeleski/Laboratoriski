package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class MostFrequentSubstring {

	public static String findSubstring(String input) {
		Map<String, Integer> lengthByString = new HashMap<>();
		List<String> longestStrings = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < input.length(); i++) {
			String current = "";
			for (int j = i; j < input.length(); j++) {
				String c = String.valueOf(input.charAt(j));
				current += c;

				if (!lengthByString.containsKey(current)) {
					lengthByString.put(current, 1);
				} else {
					lengthByString.computeIfPresent(current,
							(k, occurences) -> ++occurences);
				}

				Integer currentLength = lengthByString.get(current);
				if (currentLength > max) {
					max = currentLength;
					longestStrings.clear();
					longestStrings.add(current);
				} else if (currentLength == max) {
					longestStrings.add(current);
				}
			}
		}

		return longestStrings.stream()
				.max(Comparator.comparing(String::length)
						.thenComparing(Comparator.reverseOrder())).orElse(" ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(findSubstring(input));
	}
}
