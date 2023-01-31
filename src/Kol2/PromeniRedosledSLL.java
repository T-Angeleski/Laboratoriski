package Kol2;

import DadeniKodovi.Heshiranje_Kodovi.SLL;
import DadeniKodovi.Heshiranje_Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PromeniRedosledSLL {

	//Rotate list one left, k-times
	private static void transform(SLL<Integer> list, int k) {
		for (int i = 0; i < k; i++) {
			SLLNode<Integer> tmp = list.getFirst();
			SLLNode<Integer> first = tmp;

			//Get last node
			while (tmp.succ != null) {
				tmp = tmp.succ;
			}

			list.first = first.succ;
			first.succ = null;
			tmp.succ = first;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		int k = sc.nextInt();
		transform(list, k);
		System.out.println(list);
	}
}
