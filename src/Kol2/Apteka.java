package Kol2;

/*
otrebno e da se napravi kompjuterska aplikacija so koja ke se zabrza rabotenjeto na edna apteka.
pritoa aplikacijata ke mu ovozmozi na korisnikot(farmacevtot)
brzo da gi prebaruva niz ogromno mnozest so lekovi koi
se vneseni vo sistemomt i toj treba da prebaravuva koj e sleden:
dovolno e da gi vnese prvite 3 bukvi od imeto na lekot
za da moze da mu se izlezi dali go ima vo sistemot.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Medicine {
	String name;
	int isPositive;
	int price;
	int amount;

	public Medicine(String name, int isPositive, int price, int amount) {
		this.name = name;
		this.isPositive = isPositive;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}

public class Apteka {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, List<Medicine>> medicineByInitials = new HashMap<>();
		for (int i = 0; i < n; i++) {
			//Name 1 20 4
			String line = br.readLine();
			String[] parts = line.split(" ");

			String name = parts[0];
			String initials = name.substring(0, 3);
			int isPositive = Integer.parseInt(parts[1]);
			int price = Integer.parseInt(parts[2]);
			int amount = Integer.parseInt(parts[3]);

			Medicine med = new Medicine(name, isPositive, price, amount);

			medicineByInitials.putIfAbsent(initials, new ArrayList<>());
			medicineByInitials.get(initials).add(med);
		}


//	    Neuspesno kupuvanje!
//      Go nema na zaliha lekot: PALIN
//
//      Uspesno kupuvanje!
//      Lek: KREON Kupena kolicina: 5
//      Preostanuvaat uste: 5 lekovi KREON

		while (true) {
			String name = br.readLine();
			if (name.equals("KRAJ")) return;

			int amount = Integer.parseInt(br.readLine());

			//Find medicine with first 3 initials then search for entire name
			String initials = name.substring(0, 3).toUpperCase();

			List<Medicine> medicines = medicineByInitials.get(initials);

			boolean found = false;
			for (Medicine medicine : medicines) {
				String medName = medicine.getName();
				if (name.equalsIgnoreCase(medName)) {
					//Medicine found
					found = true;

					int currentAmount = medicine.getAmount();

					//Not enough in stock
					if (amount > currentAmount) {
						break;
					}
					medicine.setAmount(currentAmount - amount);

					System.out.println("Uspesno kupuvanje!");
					System.out.printf("Lek: %s Kupena kolicina: %d\n",
							medicine.getName(), amount);
					System.out.printf("Preostanuvaat uste: %d lekovi %s\n",
							medicine.getAmount(), medicine.getName());
					break;
				}
			}

			if (!found) {
				//Medicine not in stock
				System.out.println("Neuspesno kupuvanje!");
				System.out.printf("Go nema na zaliha lekot: %s\n", name.toUpperCase());
			}
		}
	}
}
