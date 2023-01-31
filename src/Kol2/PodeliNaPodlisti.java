package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Element {
	private int id;

	public Element(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}

public class PodeliNaPodlisti {

	private static void listTransform(SLL<Element> original) {
		// dolzina / 10   ->   1.4   Prvi 4 po 2 elementi, naredni po 1 element
		// 4.2  -> Prvi 2 po 5 elementi, naredni 8 po 4

		int dolzina = original.getLength();
		int brojPovekje = dolzina % 10;
		int poKolkuPovekje = (dolzina / 10) + 1;
		int poKolkuOstanati = dolzina / 10;

		//14 elem -> 4 * 2, 6 * 1
		List<SLL<Element>> result = new ArrayList<>();
		SLLNode<Element> tmp = original.getFirst();
		for (int i = 0; i < 10; i++) {
			SLL<Element> nova = new SLL<>();
			if (i < brojPovekje) {
				int count = poKolkuPovekje;
				while (count != 0) {
					nova.insertLast(tmp.element);
					tmp = tmp.succ;
					--count;
				}
			} else {
				int count = poKolkuOstanati;
				while (count != 0) {
					nova.insertLast(tmp.element);
					tmp = tmp.succ;
					--count;
				}
			}
			result.add(nova);
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());
		SLL<Element> list = new SLL<Element>();

		for (int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			list.insertLast(new Element(n));
		}

		listTransform(list);
	}
}
