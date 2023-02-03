package Kol2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KumanovskiDijalekt {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, String> wordsByDialect = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			wordsByDialect.put(parts[0], parts[1]);
		}

		String[] words = br.readLine().split(" ");


		for (String word : words) {
			char hasSpecial = '#';
			//Handle special char
			if (word.charAt(word.length() - 1) == '.' ||
					word.charAt(word.length() - 1) == ',' ||
					word.charAt(word.length() - 1) == '!' ||
					word.charAt(word.length() - 1) == '?') {
				hasSpecial = word.charAt(word.length() - 1);
				word = word.substring(0, word.length() - 1);
			}

			//Handle uppercase
			String filtered;
			String result;

			if (!wordsByDialect.containsKey(word.toLowerCase())) {
				if (hasSpecial == '#') System.out.print(word + " ");
				else System.out.print(word + hasSpecial + " ");
			} else {

				if (Character.isUpperCase(word.charAt(0))) {
					filtered = word.toLowerCase();
					result = wordsByDialect.get(filtered);

					char c = Character.toUpperCase(result.charAt(0));
					result = c + result.substring(1);

				} else {
					result = wordsByDialect.get(word);
				}


				if (hasSpecial == '#') System.out.print(result + " ");
				else {
					result += hasSpecial;
					System.out.print(result + " ");
				}
			}
		}
	}
}
