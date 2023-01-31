package Labs7;

import DadeniKodovi.Kodovi.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RoutingHashJava {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = findClosestPrime(n);
		OBHT<String, List<String>> routers = new OBHT<>(m + 1);

		for (int i = 0; i < n; i++) {
			String key = br.readLine();

			String value = br.readLine();
			String[] IPs = value.split(",");
			List<String> values = new ArrayList<>(Arrays.asList(IPs)); //majstorija
			routers.insert(key, values);
		}

		int input = Integer.parseInt(br.readLine());
		for (int i = 0; i < input; i++) {
			//Key then value
			String inputKey = br.readLine();
			String inputValue = br.readLine();

			//delete last octet from IP
			String filteredValue = filterValue(inputValue);


			int search = routers.search(inputKey);
			if (search != -1) {
				boolean found = false;
				List<String> values = routers.buckets[search].value;
				for (String value : values) {
					String filtered = filterValue(value);
					if (filtered.equals(filteredValue)) {
						found = true;
					}
				}

				if (found) System.out.println("postoi");
				else System.out.println("ne postoi");
			} else {
				System.out.println("ne postoi");
			}
		}
	}

	private static String filterValue(String inputValue) {
		StringBuilder result = new StringBuilder();
		int counter = 0;
		for (char c : inputValue.toCharArray()) {
			if (c == '.') {
				counter++;
			}
			result.append(c);
			if (counter == 3) {
				break;
			}
		}
		return result.toString();
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
