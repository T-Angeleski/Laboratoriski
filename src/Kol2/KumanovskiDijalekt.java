package Kol2;

import DadeniKodovi.Kodovi.CBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KumanovskiDijalekt {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		int N = Integer.parseInt(br.readLine());

		CBHT<String, String> dialectToStandard = new CBHT<>(N);

		//nego otkolku
		String pairs[] = new String[N];
		for (int i = 0; i < N; i++) {
			pairs[i] = br.readLine();

			String[] parts = pairs[i].split("\\s+");
			dialectToStandard.insert(parts[0], parts[1]);
		}

		String text = br.readLine();

		//Vasiot kod tuka

		if (N == 0) {
			System.out.println(text);
			return;
		}

		//With . , ?
		String[] words = text.split("\\s+");
		char character = '#';
		String query, value;
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			character = '#'; //Nema character

			if (word.charAt(word.length() - 1) == '.' ||
					word.charAt(word.length() - 1) == ',' ||
					word.charAt(word.length() - 1) == '!' ||
					word.charAt(word.length() - 1) == '?') {
				character = word.charAt(word.length() - 1);

				//Remove from end of word
				word = word.substring(0, word.length() - 1);

			}

			query = word.toLowerCase();

			if (dialectToStandard.search(query) != null) {
				value = dialectToStandard.search(query).element.value;

				//If original word starts with uppercase
				if (Character.isUpperCase(word.charAt(0))) {
					result.append(Character.toUpperCase(value.charAt(0)));
					result.append(value.substring(1));
				} else {
					//Doesn't start with uppercase
					result.append(value);
				}
			} else {
				//Word not in map
				result.append(word);
			}


			if (character != '#') result.append(character);

			result.append(" ");
		}

		System.out.println(result);
	}
}
