package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RodendeniIspitna {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> peopleByDate = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			peopleByDate.put(parts[2], parts[0] + " " + parts[1]);
		}

	}
}
