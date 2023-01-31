package Kol2;

import java.io.IOException;
import java.util.Scanner;

import DadeniKodovi.Heshiranje_Kodovi.SLL;
import DadeniKodovi.Heshiranje_Kodovi.SLLNode;

public class SpojSLLNaizmenicno {
	//Spoj taka sto naizmenicno
	//Dodadi 2 od prva pa 2 od vtora
	//Jazli sto kje ostanat dodadi na kraj (prva pa vtora)
	private static SLL<Integer> combineLists(SLL<Integer> list1, SLL<Integer> list2) {
		SLL<Integer> result = new SLL<>();
		SLLNode<Integer> tmpFirst = list1.getFirst();
		SLLNode<Integer> tmpSecond = list2.getFirst();
		int count1, count2;

		while (tmpFirst != null || tmpSecond != null) {
			count1 = count2 = 0;

			while (tmpFirst != null && count1 < 2) {
				result.insertLast(tmpFirst.element);
				tmpFirst = tmpFirst.succ;
				count1++;
			}

			while (tmpSecond != null && count2 < 2) {
				result.insertLast(tmpSecond.element);
				tmpSecond = tmpSecond.succ;
				count2++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list1 = new SLL<>();
		for (int i = 0; i < n; i++) {
			list1.insertLast(sc.nextInt());
		}

		int m = sc.nextInt();
		SLL<Integer> list2 = new SLL<>();
		for (int i = 0; i < m; i++) {
			list2.insertLast(sc.nextInt());
		}

		SLL<Integer> result = combineLists(list1, list2);
		System.out.println(result);

	}


}
