package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Driver implements Comparator<Driver> {
	String ID;
	String name;
	String surname;
	int speed;
	Date time;
	long realTime;

	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

	public Driver(String ID, String name, String surname) {
		this.ID = ID;
		this.name = name;
		this.surname = surname;
		speed = 0;
		realTime = 0;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Date getTime() {
		return time;
	}

	public int getSpeed() {
		return speed;
	}

	public void setRealTime(String time) throws ParseException {
		realTime = format.parse(time).getTime();
	}

	public long getRealTime() {
		return realTime;
	}

	@Override
	public String toString() {
		return String.format("%s %s", name, surname);
	}

	@Override
	public int compare(Driver o1, Driver o2) {
		return Long.compare(o1.realTime, o2.realTime);
	}


}

public class SemaforiKolokvium {
	public static void main(String[] args) throws ParseException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Driver> driverByID = new HashMap<>();
		List<Driver> overSpeedLimit = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] parts = line.split("\\s+");

			Driver driver = new Driver(parts[0], parts[1], parts[2]);
			driverByID.putIfAbsent(parts[0], driver);
		}


		int maxSpeed = Integer.parseInt(br.readLine());
		String records = br.readLine();
		String[] parts = records.split("\\s+");

		for (int i = 0; i < parts.length - 2; i += 3) {

			String id = parts[i];
			int speed = Integer.parseInt(parts[i + 1]);
			String time = parts[i + 2];

			Driver driver = driverByID.get(id);
			driver.setSpeed(speed);
			driver.setRealTime(time);
			if (driver.getSpeed() > maxSpeed) overSpeedLimit.add(driver);
		}

		overSpeedLimit.stream()
				.sorted(Comparator.comparing(Driver::getRealTime))
				.forEach(System.out::println);


		br.close();
	}
}
