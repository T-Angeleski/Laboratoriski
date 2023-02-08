package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DomeniKolokviumHash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> domainVisits = new HashMap<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {

			String line = br.readLine();
			String[] parts = line.split(" ");
			int visits = Integer.parseInt(parts[0]); //5043

			String domain = parts[1]; //courses.finki.ukim.mk

			domainVisits.putIfAbsent(domain, 0);
			domainVisits.computeIfPresent(domain, (k, v) -> v + visits);
			for (char c : domain.toCharArray()) {
				if (c == '.') {
					//Get prefix after .
					//finki.ukim.mk ukim.mk mk
					int start = domain.indexOf(c);
					domain = domain.substring(start + 1);

					domainVisits.putIfAbsent(domain, 0);
					domainVisits.computeIfPresent(domain, (k, v) -> v + visits);
				}
			}
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			Integer visits = domainVisits.get(line);
			System.out.println(visits);
		}
	}
}
