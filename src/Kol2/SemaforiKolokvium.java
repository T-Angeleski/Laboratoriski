package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Vozac {
	String registration;
	String name;
	List<Long> time;

	public Vozac(String registration, String name) {
		this.registration = registration;
		this.name = name;
		time = new ArrayList<>();
	}


	public String getName() {
		return name;
	}

	public List<Long> getTime() {
		return time;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class SemaforiKolokvium {
	public static void main(String[] args) throws ParseException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, Vozac> driversByRegistration = new HashMap<>();
		br.lines()
				.limit(n)
				.forEach(line -> {
					String[] parts = line.split(" ");
					String registration = parts[0];
					String name = String.format("%s %s", parts[1], parts[2]);
					Vozac vozac = new Vozac(registration, name);
					driversByRegistration.putIfAbsent(registration, vozac);
				});

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		int speedLimit = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < input.length - 2; i += 3) {

			String registration = input[i];
			int speed = Integer.parseInt(input[i + 1]);
			String time = input[i + 2];

			if (speed > speedLimit) {
				long timeInMs = formatter.parse(time).getTime();
				driversByRegistration.get(registration).getTime().add(timeInMs);
			}

		}

		Map<Long, Vozac> timesByVozac = new HashMap<>();
		for (Map.Entry<String, Vozac> entry : driversByRegistration.entrySet()) {
			List<Long> times = entry.getValue().getTime();
			for (Long time : times) {
				timesByVozac.put(time, entry.getValue());
			}
		}

		timesByVozac.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.forEach(driver -> System.out.println(driver.getValue()));
	}
}
