package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class IzbrisiPoslednoPojavuvanjeSLL {
	//Delete last occurence of element k in SLL
	private static void deleteDuplicates(SLL<Integer> list, int k) {
		SLLNode<Integer> tmp = list.getFirst();
		SLLNode<Integer> prev = null;
		SLLNode<Integer> toDelete = null;

		while (tmp.succ != null) {
			if (tmp.succ.element == k) {
				toDelete = tmp.succ;
				prev = tmp;
			}
			tmp = tmp.succ;
		}

		//Ako toj element so se brishe e prv i samo tamu se pojavuva
		if (k == list.getFirst().element) {
			list.first = list.first.succ;
		} else {
			//Ako posleden e elementot za briseneje
			if (toDelete.succ == null) {
				prev.succ = null;
			} else prev.succ = toDelete.succ;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		int k = sc.nextInt();
		deleteDuplicates(list, k);
		System.out.println(list);
	}
}
