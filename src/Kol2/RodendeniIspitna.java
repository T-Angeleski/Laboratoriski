package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class RodendeniIspitna {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> peopleByDayMonth = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");

			String[] date = parts[2].split("/");

			String dayMonth = date[0] + date[1];
			String person = parts[0] + " " + parts[1] + " " + date[2];

			if (peopleByDayMonth.get(dayMonth) == null) {
				peopleByDayMonth.put(dayMonth, person);
			} else {
				String value = peopleByDayMonth.get(dayMonth);
				String result = value + "/" + person;
				peopleByDayMonth.put(dayMonth, result);
			}

		}

		String[] date = br.readLine().split("/");
		String dayMonth = date[0] + date[1];
		int year = Integer.parseInt(date[2]);

		String start = peopleByDayMonth.get(dayMonth);
		List<String> resultPeople = new ArrayList<>();

		String[] people = start.split("/");
		for (String person : people) {
			//Ime Prezime 1987
			String[] parts = person.split(" ");

			String name = parts[0] + " " + parts[1] + " ";

			int personYear = Integer.parseInt(parts[2]);
			String age = String.valueOf(year - personYear);
			String newPerson = name + age;

			resultPeople.add(newPerson);
		}

		resultPeople.stream()
				.sorted(Comparator.naturalOrder())
				.forEach(System.out::println);
	}
}
