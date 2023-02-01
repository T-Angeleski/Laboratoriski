package Kol2;

import DadeniKodovi.Kodovi.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class ProverkaNaSpeluvanje {

	private static int findClosestPrime(int n) {
		while (true) {
			if (isPrime(n)) return n;
			++n;
		}
	}

	private static boolean isPrime(int n) {
		if (n == 1) return true;
		if (n == 2) return false;
		return IntStream.range(2, n - 1).allMatch(i -> n % i != 0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		OBHT<String, Integer> wordsCount = new OBHT<>(findClosestPrime(n));
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			wordsCount.insert(word, 1);
		}

		String input = br.readLine();
		String[] words = input.split(" ");
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			char comparison = word.charAt(word.length() - 1);
			word  = word.toLowerCase();

			if (comparison == '.' || comparison == ',' ||
					comparison == '!' || comparison == '?') {
				word = word.substring(0, word.length() - 1);
			}

			if(wordsCount.search(word) == -1) {
				result.append(word).append("\n");
			}
		}

		if(result.isEmpty()) System.out.println("Bravo");
		else System.out.println(result);
	}
}
