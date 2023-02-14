package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;

class Athlete {
	int id;
	double time;

	public Athlete(int id, double time) {
		this.id = id;
		this.time = time;
	}

	public double getTime() {
		return time;
	}

	@Override
	public String toString() {
		return String.format("%d", id);
	}
}

public class Athletes {

	//Izbrisi atleticari koj imaat poloso vreme
	//od najlosoto vreme na pobednici
	private static void competition(SLL<Athlete> winners, SLL<Athlete> athletes) {
		//Find worst time from winners
		SLLNode<Athlete> tmp = winners.getFirst();
		double worst = tmp.element.getTime();
		tmp = tmp.succ;

		while (tmp != null) {
			worst = Math.max(worst, tmp.element.getTime());
			tmp = tmp.succ;
		}

		//Delete all with worse time ( time > worst )
		tmp = athletes.getFirst();
		while (tmp != null) {
			if (tmp.element.getTime() > worst)
				athletes.delete(tmp);
			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numWinners = Integer.parseInt(sc.nextLine());
		int numAthletes = Integer.parseInt(sc.nextLine());
		SLL<Athlete> winners = new SLL<>();
		SLL<Athlete> athletes = new SLL<>();

		for (int i = 0; i < numWinners; i++) {
			String[] parts = sc.nextLine().split(" ");
			int id = Integer.parseInt(parts[0]);
			double time = Double.parseDouble(parts[1]);

			Athlete athlete = new Athlete(id, time);
			winners.insertLast(athlete);
		}

		for (int i = 0; i < numAthletes; i++) {
			String[] parts = sc.nextLine().split(" ");
			int id = Integer.parseInt(parts[0]);
			double time = Double.parseDouble(parts[1]);

			Athlete athlete = new Athlete(id, time);
			athletes.insertLast(athlete);
		}

		competition(winners, athletes);
		System.out.println(athletes);
	}

}
