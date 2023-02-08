package Kol2;

import DadeniKodovi.Kodovi.CBHT;
import DadeniKodovi.Kodovi.MapEntry;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DedoMrazUliciHash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//Kid -> Street
		CBHT<String, String> streetsByKids = new CBHT<>(2 * n);
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			String street = br.readLine();
			streetsByKids.insert(name, street);
		}


		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] parts = br.readLine().split(" ");
			String oldValue = parts[0];
			String newValue = parts[1];

			//Search all entries for oldValue
			for (SLLNode<MapEntry<String, String>> entry : streetsByKids.buckets) {
				if (entry != null) {
					String valueMap = entry.element.value;
					String[] words = entry.element.value.split(" ");

					if (words[0].equalsIgnoreCase(oldValue)) {
						//Add new match + parts[1] + parts[2]
					}
				}
			}

		}
	}
}
