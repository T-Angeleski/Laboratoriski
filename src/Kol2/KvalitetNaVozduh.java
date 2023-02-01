package Kol2;

import DadeniKodovi.Kodovi.CBHT;
import DadeniKodovi.Kodovi.MapEntry;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class KvalitetNaVozduh {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		CBHT<String, Double> qualityByCity = new CBHT<>(2 * n);
		CBHT<String, Integer> countByCity = new CBHT<>(2 * n);

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			String city = parts[0];
			double quality = Double.parseDouble(parts[1]);

			//Ako e prazno ( od pocetok)
			if (qualityByCity.search(city) == null) {
				qualityByCity.insert(city, quality);
			} else {
				Double value = qualityByCity.search(city).element.value;
				qualityByCity.insert(city, quality + value);
			}

			//Ako e prazno
			if (countByCity.search(city) == null) {
				countByCity.insert(city, 1);
			} else {
				Integer count = countByCity.search(city).element.value;
				countByCity.insert(city, ++count);
			}
		}
		String city = br.readLine();

		//Presmetaj za toj grad
		Double sum = qualityByCity.search(city).element.value;
		Integer count = countByCity.search(city).element.value;

//		DecimalFormat df = new DecimalFormat("######.##");
//		double sumFormatted = Double.parseDouble(df.format(sum));
		double result = sum / count;

		System.out.printf("%.2f", result);

	}
}
