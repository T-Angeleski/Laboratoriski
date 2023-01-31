package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		SLL<Worker> devTeam = new SLL<>();
		SLL<Worker> qaTeam = new SLL<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			Worker w = new Worker(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]));

			devTeam.insertLast(w);
		}

		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			Worker w = new Worker(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]));

			qaTeam.insertLast(w);
		}

		alterTeams(devTeam, qaTeam);
		System.out.println(devTeam);
		System.out.println(qaTeam);
	}

}
