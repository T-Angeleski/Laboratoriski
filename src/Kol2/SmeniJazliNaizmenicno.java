package Kol2;

import DadeniKodovi.Heshiranje_Kodovi.SLL;
import DadeniKodovi.Heshiranje_Kodovi.SLLNode;

import java.util.Scanner;

public class SmeniJazliNaizmenicno {
	private static void inverseList(SLL<Integer> list) {
		SLLNode<Integer> tmp = list.getFirst();
		SLLNode<Integer> prev = null;

		//TODO DRUZI PUT
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list1 = new SLL<>();
		for (int i = 0; i < n; i++) {
			list1.insertLast(sc.nextInt());
		}

		inverseList(list1);

		System.out.println(list1);
	}


}
