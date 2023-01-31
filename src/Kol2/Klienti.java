package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Client {
	int id;
	int loyalty;
	int accounts;
	int importance;

	public Client(int id, int loyalty, int accounts) {
		this.id = id;
		this.loyalty = loyalty;
		this.accounts = accounts;
		this.importance = (loyalty * 10) + (accounts * 20);
	}

	public int getImportance() {
		return importance;
	}

	@Override
	public String toString() {
		return id + " ";
	}
}

public class Klienti {
	private static void alterTeams(SLL<Client> normal, SLL<Client> golden) {
		//Otstrani najmalku vazen klient od Golden
		SLLNode<Client> tmp = golden.getFirst();
		SLLNode<Client> leastImportant = tmp;
		int min = tmp.element.getImportance();
		tmp = tmp.succ;

		while (tmp != null) {
			if (tmp.element.getImportance() < min) {
				leastImportant = tmp;
				min = tmp.element.getImportance();
			}
			tmp = tmp.succ;
		}

		normal.insertLast(leastImportant.element);
		golden.delete(leastImportant);

		//Najdi i otstrani najmnogu vazen od Normal
		tmp = normal.getFirst();
		SLLNode<Client> mostImportant = tmp;
		int max = tmp.element.getImportance();
		tmp = tmp.succ;

		while (tmp != null) {
			if (tmp.element.getImportance() > max) {
				max = tmp.element.getImportance();
				mostImportant = tmp;
			}
			tmp = tmp.succ;
		}

		golden.insertLast(mostImportant.element);
		normal.delete(mostImportant);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		SLL<Client> normal = new SLL<>();
		SLL<Client> golden = new SLL<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			Client w = new Client(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

			normal.insertLast(w);
		}

		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			Client w = new Client(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

			golden.insertLast(w);
		}

		alterTeams(normal, golden);
		System.out.println(normal);
		System.out.println(golden);
	}
}
