package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class RepeatedDNA {
	/*
	Given a string s that represents a DNA sequence,
	 return all the 10-letter-long sequences (substrings)
	 that occur more than once in a DNA molecule.
	 You may return the answer in any order.
	*/

	public static List<String> findRepeatedDnaSequences(String s) {
		HashMap<String, Integer> repeatedSequences = new HashMap<>();
		for (int i = 0; i < s.length() - 9; i++) {
			String current = s.substring(i, i + 10);
			repeatedSequences.putIfAbsent(current, 0);
			repeatedSequences.computeIfPresent(current, (k, occ) -> ++occ);
		}

		return repeatedSequences.entrySet().stream()
				.filter(i -> i.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		List<String> result = findRepeatedDnaSequences(input);
		System.out.println(result);
	}
}
