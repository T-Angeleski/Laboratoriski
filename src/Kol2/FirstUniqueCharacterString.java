package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterString {
	/*
	Given a string s,
	 find the first non-repeating character in it
	 and return its index. If it does not exist, return -1
	*/
	public static int firstUniqueChar(String s) {
		Map<Character, Integer> countEachChar = new HashMap<>();
		for (char c : s.toCharArray()) {
			countEachChar.putIfAbsent(c, 0);
			countEachChar.computeIfPresent(c, (k, count) -> ++count);
		}

		for (char c : s.toCharArray()) {
			if (countEachChar.get(c) == 1) return s.indexOf(c);
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(firstUniqueChar(input));
	}
}
