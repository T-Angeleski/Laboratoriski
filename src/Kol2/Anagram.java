package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Anagram {
	/*
	Given two strings s and t, return true if t is an anagram of s,
	and false otherwise.
	An Anagram is a word or phrase formed by
	rearranging the letters of a different word or phrase,
	typically using all the original letters exactly once.
	*/
	public static boolean isAnagram(String s, String t) {
		Map<Character, Integer> charsCountS = new TreeMap<>();
		Map<Character, Integer> charsCountT = new TreeMap<>();
		for (char c : s.toCharArray()) {
			charsCountS.putIfAbsent(c, 0);
			charsCountS.computeIfPresent(c, (k, count) -> ++count);
		}

		for (char c : t.toCharArray()) {
			charsCountT.putIfAbsent(c, 0);
			charsCountT.computeIfPresent(c, (k, count) -> ++count);
		}

		if (charsCountS.keySet().size() != charsCountT.keySet().size()) return false;

		for (Map.Entry<Character, Integer> entry : charsCountS.entrySet()) {
			Character character = entry.getKey();
			Integer integer = entry.getValue();
			if (!Objects.equals(charsCountT.get(character), integer)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		System.out.println(isAnagram(s, t));
	}
}
