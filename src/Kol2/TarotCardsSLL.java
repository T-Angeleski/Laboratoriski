package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Card {
	int id;
	int rank;

	public Card(int id, int rank) {
		this.id = id;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("%d", id);
	}
}

public class TarotCardsSLL {

	/**
	 * Od prva lista zemi prva i stavi kako posledna vo vtora lista
	 * Od vtora lista zemi prva i stavi kako posledna vo prva lista
	 * zemi predposledna karta od prva lista
	 * i stavi vo sredina na vtora lista
	 */
	private static void tarotCards(SLL<Card> prvaLista, SLL<Card> vtoraLista) {
		//1
		vtoraLista.insertLast(prvaLista.getFirst().element);
		SLLNode<Card> tmp = prvaLista.getFirst();
		prvaLista.first = tmp.succ;

		//2
		prvaLista.insertLast(vtoraLista.getFirst().element);
		tmp = vtoraLista.getFirst();
		vtoraLista.first = tmp.succ;

		//3
		//Delete predposledna
		tmp = prvaLista.getFirst();
		SLLNode<Card> prev = null;
		while (tmp.succ.succ != null) {
			prev = tmp;
			tmp = tmp.succ;
		}

		//Insert in middle
		prev.succ = tmp.succ;
		SLLNode<Card> toInsert = tmp;

		SLLNode<Card> fast = vtoraLista.getFirst();
		SLLNode<Card> middle = vtoraLista.getFirst();

		while (fast.succ != null && fast.succ.succ != null) {
			fast = fast.succ.succ;
			middle = middle.succ;
		}

		tmp = vtoraLista.getFirst();
		while (tmp != null) {
			if (tmp.element == middle.element) {
				SLLNode<Card> extra = tmp.succ;
				tmp.succ = toInsert;
				toInsert.succ = extra;
			}
			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SLL<Card> prvaLista = new SLL<>();
		SLL<Card> vtoraLista = new SLL<>();

		br.lines()
				.limit(6)
				.forEach(line -> {
					String[] parts = line.split(" ");
					int id = Integer.parseInt(parts[0]);
					int rank = Integer.parseInt(parts[1]);

					Card card = new Card(id, rank);
					prvaLista.insertLast(card);
				});

		br.lines()
				.limit(6)
				.forEach(line -> {
					String[] parts = line.split(" ");
					int id = Integer.parseInt(parts[0]);
					int rank = Integer.parseInt(parts[1]);

					Card card = new Card(id, rank);
					vtoraLista.insertLast(card);
				});

		tarotCards(prvaLista, vtoraLista);
		System.out.println(prvaLista);
		System.out.println(vtoraLista);
	}

}
