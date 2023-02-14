package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Hero {
	int id;
	int power;
	int numAttacks;

	public Hero(int id, int power, int numAttacks) {
		this.id = id;
		this.power = power;
		this.numAttacks = numAttacks;
	}

	public int getStrength() {
		return power * numAttacks;
	}

	@Override
	public String toString() {
		return id + " ";
	}
}

public class HeroesSLL {


	private static void startHeroesGame(SLL<Hero> playerOne, SLL<Hero> playerTwo) {
		//Find the strongest card from p1, remove, add to middle od p2
		SLLNode<Hero> tmp = playerOne.getFirst();
		SLLNode<Hero> toRemove = tmp;
		int max = tmp.element.getStrength();
		tmp = tmp.succ;

		//Find max
		while (tmp != null) {
			if (tmp.element.getStrength() > max) {
				max = tmp.element.getStrength();
				toRemove = tmp;
			}
			tmp = tmp.succ;
		}

		//Delete
		tmp = playerOne.getFirst();
		if (toRemove.equals(playerOne.first)) {
			playerOne.first = playerOne.first.succ;
		} else {
			while (tmp.succ != toRemove && tmp.succ.succ != null) {
				tmp = tmp.succ;
			}
			if (tmp.succ == toRemove) tmp.succ = tmp.succ.succ;
		}

		//Find middle of playerTwo
		SLLNode<Hero> fast = playerTwo.getFirst();
		SLLNode<Hero> middle = playerTwo.getFirst();
		while (fast.succ != null && fast.succ.succ != null) {
			fast = fast.succ.succ;
			middle = middle.succ;
		}

		//Insert in middle
		tmp = playerTwo.getFirst();
		while (tmp != null) {
			if (tmp.equals(middle)) {
				SLLNode<Hero> extra = tmp.succ;
				tmp.succ = toRemove;
				toRemove.succ = extra;
			}
			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) {
		SLL<Hero> playerOne = new SLL<>();
		SLL<Hero> playerTwo = new SLL<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.lines()
				.limit(6)
				.forEach(line -> {
					String[] parts = line.split(" ");
					int id = Integer.parseInt(parts[0]);
					int power = Integer.parseInt(parts[1]);
					int numAttacks = Integer.parseInt(parts[2]);
					Hero hero = new Hero(id, power, numAttacks);

					playerOne.insertLast(hero);
				});

		br.lines()
				.limit(6)
				.forEach(line -> {
					String[] parts = line.split(" ");
					int id = Integer.parseInt(parts[0]);
					int power = Integer.parseInt(parts[1]);
					int numAttacks = Integer.parseInt(parts[2]);
					Hero hero = new Hero(id, power, numAttacks);

					playerTwo.insertLast(hero);
				});

		startHeroesGame(playerOne, playerTwo);
		System.out.println(playerOne);
		System.out.println(playerTwo);
	}

}
