package Kol2;

import DadeniKodovi.Kodovi.CBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CovidHash {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		CBHT<String, Integer> countPositiveByCity = new CBHT<>(n);
		CBHT<String, Integer> countNegativeByCity = new CBHT<>(n);


		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			String city = parts[0];
			String surname = parts[1];
			String hasDisease = parts[2];

			if (hasDisease.equalsIgnoreCase("pozitiven")) {
				if (countPositiveByCity.search(city) == null) {
					countPositiveByCity.insert(city, 1);
				} else {
					Integer count = countPositiveByCity.search(city).element.value;
					countPositiveByCity.insert(city, count + 1);
				}

			} else {

				if (countNegativeByCity.search(city) == null) {
					countNegativeByCity.insert(city, 1);
				} else {
					Integer count = countNegativeByCity.search(city).element.value;
					countNegativeByCity.insert(city, count + 1);
				}

			}
		}

		String city = br.readLine();

		//Risk factor numPos / numPos + numNeg

		Integer numPos = countPositiveByCity.search(city).element.value;
		Integer numNeg = countNegativeByCity.search(city).element.value;

		Double riskFactor = (double) numPos / (numPos + numNeg);
		System.out.println(riskFactor);
	}
}
