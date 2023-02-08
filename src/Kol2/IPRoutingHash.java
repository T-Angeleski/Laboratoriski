package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class IPRoutingHash {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, String> interfacesByRouter = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String router = br.readLine();
			String[] interfaces = br.readLine().split(",");

			String filtered = "";
			for (String anInterface : interfaces) {
				int end = anInterface.lastIndexOf(".");
				filtered += (anInterface.substring(0, end)) + ",";
			}
			interfacesByRouter.put(router, filtered);
		}

		//Baranje
		//int m = Integer.parseInt(br.readLine());
		interfacesByRouter.forEach((s, s2) -> {
			System.out.println(s + " " + s2);
		});
	}
}
