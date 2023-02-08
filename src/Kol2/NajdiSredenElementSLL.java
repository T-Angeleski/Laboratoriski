package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class NajdiSredenElementSLL {

	private static void findMiddleElement(SLL<Integer> list) {
		SLLNode<Integer> slow = list.getFirst();
		SLLNode<Integer> fast = list.getFirst();

		while (fast != null && fast.succ != null) {
			fast = fast.succ.succ;
			slow = slow.succ;
		}
		//slow = middle

		SLLNode<Integer> tmp = slow;
		while (tmp != null) {
			System.out.print(tmp + " ");
			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		findMiddleElement(list);
	}


}
