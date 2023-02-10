package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DeleteElementFromEndSLL {
	private static void deleteElement(SLL<Integer> list, int n) {
		//Find length
		int length = 0;
		SLLNode<Integer> tmp = list.getFirst();
		while (tmp != null) {
			tmp = tmp.succ;
			++length;
		}

		tmp = list.getFirst();
		for (int i = 0; i < (length - n); i++) {
			tmp = tmp.succ;
		}
		list.delete(tmp);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		int x = sc.nextInt();
		deleteElement(list, x);
		System.out.println(list);
	}

}
