package Labs7;

import DadeniKodovi.Heshiranje_Kodovi.CBHT;
import DadeniKodovi.Heshiranje_Kodovi.MapEntry;
import DadeniKodovi.Heshiranje_Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Lozinki {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int m = findClosestPrime(N);
		CBHT<String, String> passwordsTable = new CBHT<>(m + 1);

		for (int i = 1; i <= N; i++) {
			String imelozinka = br.readLine();
			String[] pom = imelozinka.split(" ");

			passwordsTable.insert(pom[0], pom[1]);
		}


		while (true) {
			String line = br.readLine();
			if (line.equals("KRAJ")) break;

			String[] parts = line.split("\\s+");
			SLLNode<MapEntry<String, String>> tableKey = passwordsTable.search(parts[0]);

			if (tableKey != null) {
				if (parts[0].equals(tableKey.element.key) && parts[1].equals(tableKey.element.value)) {
					System.out.println("Najaven");
					break;
				} else {
					System.out.println("Nenajaven");
				}
			} else {
				System.out.println("Nenajaven");
			}
		}


	}

	public static int findClosestPrime(int n) {
		for (int i = n; ; i++) {
			if (isPrime(i)) return i;
		}
	}

	public static boolean isPrime(int n) {
		if (n == 1) return true;
		if (n == 2) return false;
		return IntStream.range(2, n - 1).allMatch(i -> n % i != 0);
	}
}
