package Kol2;

import DadeniKodovi.Heshiranje_Kodovi.SLL;
import DadeniKodovi.Heshiranje_Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ChangeListSLL {

	//Site jazli pomali od X da se premestat pred jazli >= X
	private static void changeList(SLL<Integer> list, int x) {
		int n = list.getLength();
		SLLNode<Integer> tmp = list.getFirst();
		SLLNode<Integer> prev = tmp;

		for (int i = 0; i < n; i++) {
			while (tmp != null) {
				if (tmp.element >= x) {
					//Move to end and delete current place
					list.insertLast(tmp.element);
					prev.succ = tmp.succ;
				}
				tmp = tmp.succ;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		int x = sc.nextInt();
		changeList(list, x);
		System.out.println(list);
	}
}
