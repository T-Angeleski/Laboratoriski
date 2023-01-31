package Kol2;

import java.util.Scanner;

import DadeniKodovi.Heshiranje_Kodovi.SLL;
import DadeniKodovi.Heshiranje_Kodovi.SLLNode;

class Worker {
	int id;
	int age;

	public Worker(int id, int age) {
		this.id = id;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return id + " ";
	}
}

public class QADEVTeamSLL {

	public static void alterTeams(SLL<Worker> devTeam, SLL<Worker> qaTeam) {
		//Get youngest from QA
		SLLNode<Worker> tmp = qaTeam.getFirst();
		SLLNode<Worker> youngest = tmp;
		int min = tmp.element.getAge();
		tmp = tmp.succ;

		while (tmp != null) {
			if (tmp.element.getAge() < min) {
				min = tmp.element.getAge();
				youngest = tmp;
			}
			tmp = tmp.succ;
		}
		//Delete worker
		tmp = qaTeam.getFirst();
		if (tmp.equals(youngest)) {
			qaTeam.first = tmp.succ;
		} else {
			while (tmp != null) {
				if (tmp.succ.equals(youngest)) {
					tmp.succ = youngest.succ;
				}
				tmp = tmp.succ;
			}
		}

		//Get middle
		int size = devTeam.getLength();
		tmp = devTeam.getFirst();
		int middle = size / 2;
		int counter;
		if (size % 2 == 0) counter = 1;
		else counter = 0;

		while (counter != middle) {
			counter++;
			tmp = tmp.succ;
		}

		//Insert youngest in middle
		SLLNode<Worker> next = tmp.succ;
		tmp.succ = youngest;
		youngest.succ = next;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numNormal = Integer.parseInt(scanner.nextLine());
		int numGolden = Integer.parseInt(scanner.nextLine());

		SLL<Worker> normal = new SLL<Worker>();
		SLL<Worker> golden = new SLL<Worker>();

		for (int i = 0; i < numNormal; i++) {
			String line = scanner.nextLine();
			String[] parts = line.split("\\s+");
			normal.insertLast(new Worker(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
		}

		for (int i = 0; i < numGolden; i++) {
			String line = scanner.nextLine();
			String[] parts = line.split("\\s+");
			golden.insertLast(new Worker(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
		}

		alterTeams(normal, golden);
		System.out.println(normal);
		System.out.println(golden);
	}
}
