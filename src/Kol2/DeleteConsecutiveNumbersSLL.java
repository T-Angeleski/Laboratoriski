package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DeleteConsecutiveNumbersSLL {
	//Dokolku se pojavat 2 parni/neparni eden do drug,
	// izbrisi go prviot

	private static void deleteConsecutive(SLL<Integer> list) {
		SLLNode<Integer> tmp = list.getFirst().succ;
		SLLNode<Integer> prev = list.getFirst();

		while (tmp != null) {
			if (tmp.element % 2 == 0 && prev.element % 2 == 0) {
				list.delete(prev);
			}
			if (tmp.element % 2 == 1 && prev.element % 2 == 1) {
				list.delete(prev);
			}
			prev = tmp;
			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		for (int i = 0; i < n; i++)
			list.insertLast(sc.nextInt());

		deleteConsecutive(list);
		System.out.println(list);
	}

}
