package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CompanyWorker {
	int id;
	int wage;

	public CompanyWorker(int id, int wage) {
		this.id = id;
		this.wage = wage;
	}

	public int getId() {
		return id;
	}

	public int getWage() {
		return wage;
	}

	@Override
	public String toString() {
		return id + ", " + wage + "->";
	}
}

public class SLLKompanija {

	private static void layoffWorkers(SLL<CompanyWorker> list, int wage) {
		/*
		Потребно е да се отстранат сите вработени со помали плати од даден износ,
		 а остатокот да се прикажат во опаѓачки редослед во однос на ID-то.
		*/

		removeLessThanWage(list, wage);

		//Sort by ID
		boolean swapped;
		list.insertFirst(null);
		while (true) {
			swapped = false;
			SLLNode<CompanyWorker> tmp = list.getFirst();

			while (tmp.succ.succ != null) {
				if (tmp.succ.element.getId() < tmp.succ.succ.element.getId()) {
					swap(tmp);
					swapped = true;
				}
				tmp = tmp.succ;
			}
			if (!swapped) break;
		}
		list.first = list.first.succ;
	}

	private static void removeLessThanWage(SLL<CompanyWorker> list, int wage) {
		SLLNode<CompanyWorker> tmp = list.getFirst();
		while (tmp != null) {
			if (tmp.element.getWage() < wage)
				list.delete(tmp);
			tmp = tmp.succ;
		}
	}

	private static void swap(SLLNode<CompanyWorker> node) {
		SLLNode<CompanyWorker> first = node.succ;
		SLLNode<CompanyWorker> second = first.succ;
		SLLNode<CompanyWorker> last = second.succ;

		node.succ = second;
		second.succ = first;
		first.succ = last;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		SLL<CompanyWorker> list = new SLL<>();
		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			int id = Integer.parseInt(parts[0]);
			int wage = Integer.parseInt(parts[1]);
			CompanyWorker cw = new CompanyWorker(id, wage);
			list.insertLast(cw);
		}

		int wage = Integer.parseInt(br.readLine());

		layoffWorkers(list, wage);
		System.out.println(list);
	}

}
