package Kol2;

import DadeniKodovi.Kodovi.CBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IndeksKnigaHash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CBHT<String, Integer> pageByWord = new CBHT<>(51);
		while (true) {
			String line = br.readLine();
			if (line.equals("#")) break;
			String[] parts = line.split(",");
			String key = parts[0];
			int page = Integer.parseInt(parts[1].trim());
			pageByWord.insert(key.toLowerCase(), page);

			String[] words = parts[0].split(" ");
			for (String word : words) {
				pageByWord.insert(word.toLowerCase(), page);
			}
		}

		int n = Integer.parseInt(br.readLine());
		br.lines()
				.limit(n)
				.forEach(line -> {
					if (pageByWord.search(line.toLowerCase()) != null) {
						Integer value = pageByWord.search(line.toLowerCase()).element.value;
						System.out.println(value);
					} else System.out.println("Not found");
				});
	}
}
