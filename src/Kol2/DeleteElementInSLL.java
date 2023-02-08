package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DeleteElementInSLL {

	private static void deleteElement(SLL<Integer> list, int toDelete) {
		SLLNode<Integer> tmp = list.getFirst().succ;
		SLLNode<Integer> prev = list.getFirst();

		if (prev.element == toDelete) {
			list.first = tmp;
		}

		while (tmp != null) {
			if (tmp.element == toDelete) {
				prev.succ = tmp.succ;
				tmp = prev;
			}
			prev = tmp;
			tmp = tmp.succ;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		int element = sc.nextInt();
		deleteElement(list, element);
		System.out.println(list);
	}
}
