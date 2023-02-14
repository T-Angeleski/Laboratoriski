package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Cake {
	String name;
	int price;

	public Cake(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class TortiIspitnaSLL {
	// Da se izbrisat site torti so
	//cena pogolema od prosecna cena
	//nema .delete()
	private static void removeCakes(SLL<Cake> cakes) {
		SLLNode<Cake> tmp = cakes.getFirst();
		double average;
		int numCakes = 0;
		int sum = 0;
		while (tmp != null) {
			sum += tmp.element.getPrice();
			tmp = tmp.succ;
			++numCakes;
		}

		average = (double) sum / numCakes;

		//Delete with larger price than average
		tmp = cakes.getFirst();
		SLLNode<Cake> prev = tmp;
		if (tmp.element.getPrice() > average) {
			cakes.first = tmp.succ;
			tmp = tmp.succ;
			prev = tmp;
		}

		while (tmp != null) {
			if (tmp.element.getPrice() > average) {
				prev.succ = tmp.succ;
				tmp = tmp.succ;
				continue;
			}
			prev = tmp;
			tmp = tmp.succ;
		}


	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SLL<Cake> cakes = new SLL<>();
		int n = Integer.parseInt(br.readLine());
		br.lines()
				.limit(n)
				.forEach(line -> {
					String[] parts = line.split(" ");
					String name = parts[0];
					int price = Integer.parseInt(parts[1]);
					Cake cake = new Cake(name, price);

					cakes.insertLast(cake);
				});
		removeCakes(cakes);
		System.out.println(cakes);
	}

}
