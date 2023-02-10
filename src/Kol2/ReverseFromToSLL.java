package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReverseFromToSLL {

	private static void reverse(SLL<Integer> list, int m, int n) {
		SLLNode<Integer> tmp = list.getFirst();
		SLLNode<Integer> tmpM = null;
		SLLNode<Integer> tmpN = null;
		int length = list.getLength();

		for (int i = 1; i < length; i++) {
			if (i == m) tmpM = tmp;
			if (i == n) tmpN = tmp;
			tmp = tmp.succ;
		}

		tmp = list.getFirst();
		SLLNode<Integer> prev = null;
		SLLNode<Integer> next;

		while (tmp != null) {
			if (tmp.equals(tmpM)) {
				while (tmpM != tmpN) {
					next = tmpM.succ;
					tmpM.succ = prev;
					prev = tmpM;
					tmpM = next;
				}
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
		int m = sc.nextInt();
		n = sc.nextInt();
		reverse(list, m, n);
		System.out.println(list);
	}
}
