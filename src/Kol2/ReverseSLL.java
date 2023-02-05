package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReverseSLL {
	private static void reverseList(SLL<Integer> list) {
		SLLNode<Integer> tmp = list.getFirst();
		SLLNode<Integer> prev = null;
		SLLNode<Integer> next;
		while (tmp != null) {
			next = tmp.succ;
			tmp.succ = prev;
			prev = tmp;
			tmp = next;
		}
		list.first = prev;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		reverseList(list);
		System.out.println(list);
	}

}
