package Labs7;

import DadeniKodovi.Kodovi.OBHT;

import java.util.Scanner;
import java.util.stream.IntStream;

class Lek {
	int isPositive; // 0 false 1 true
	int price;
	int amount;

	public Lek(int isPositive, int price, int amount) {
		this.isPositive = isPositive;
		this.price = price;
		this.amount = amount;
	}

	public void setAmount(int amount) {
		this.amount = amount; // amount - kolku pobaral
	}

	@Override
	public String toString() {
		String isPos;
		if (isPositive == 1) isPos = "POZ";
		else isPos = "NEG";
		return String.format("%s\n%d\n%d", isPos, price, amount);
	}
}

public class Apteka {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		int numBuckets = findClosestPrime(N);

		OBHT<String, Lek> apteka = new OBHT<>(numBuckets + 1);
		//Input
		for (int i = 1; i <= N; i++) {
			//ACEROLA 0 100 1000
			String line = scanner.nextLine();
			String[] parts = line.split("\\s+");

			String key = parts[0].toUpperCase();
			int isPositive = Integer.parseInt(parts[1]);
			int price = Integer.parseInt(parts[2]);
			int amount = Integer.parseInt(parts[3]);

			Lek lek = new Lek(isPositive, price, amount);

			apteka.insert(key, lek);
		}

		//Baranje od zadaca
		while (true) {
			String lek = scanner.nextLine().toUpperCase();
			if (lek.equals("KRAJ")) break;

			int kolicina = Integer.parseInt(scanner.nextLine());

			int index = apteka.search(lek);
			if (index != -1) {
				//Check if there is enough lek
				int amountInApteka = apteka.buckets[index].value.amount;

				System.out.println(lek);
				System.out.println(apteka.buckets[index].value);


				if (kolicina > amountInApteka) {
					System.out.println("Nema dovolno lekovi");
				} else {
					System.out.println("Napravena naracka");
					//Namali kolicina na toj lek od aptekata za kolku sme naracale
					apteka.buckets[index].value.setAmount(amountInApteka - kolicina);
				}

			} else {
				System.out.println("Nema takov lek");
			}

		}

		scanner.close();
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
