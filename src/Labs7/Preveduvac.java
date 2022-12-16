package Labs7;

import DadeniKodovi.Heshiranje_Kodovi.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Preveduvac {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int m = findClosestPrime(N);
		OBHT<String, String> words = new OBHT<>(m + 1);

		//Fill table
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			String[] parts = line.split("\\s+");
			words.insert(parts[1], parts[0]);
		}


		while (true) {
			String zbor = br.readLine();
			if (zbor.equals("KRAJ")) return;
			int index = words.search(zbor);
			if (index == -1) { //If not present
				System.out.println("/");
			} else {
				System.out.println(words.buckets[index].value);
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
