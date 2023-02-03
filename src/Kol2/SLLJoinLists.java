package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SLLJoinLists {

	//Merge 2 sorted SLL without duplicates such that
	//result SLL is also sorted
	private static SLL<Integer> mergeLists(SLL<Integer> list1, SLL<Integer> list2) {
		SLLNode<Integer> tmp1 = list1.getFirst();
		SLLNode<Integer> tmp2 = list2.getFirst();
		SLL<Integer> result = new SLL<>();

		while (tmp1 != null && tmp2 != null) {
			if (tmp1.element < tmp2.element) {
				result.insertLast(tmp1.element);
				tmp1 = tmp1.succ;
			} else {
				result.insertLast(tmp2.element);
				tmp2 = tmp2.succ;
			}
		}

		while (tmp1 != null) {
			result.insertLast(tmp1.element);
			tmp1 = tmp1.succ;
		}
		while (tmp2 != null) {
			result.insertLast(tmp2.element);
			tmp2 = tmp2.succ;
		}

		deleteDuplicates(result);

		return result;
	}

	private static void deleteDuplicates(SLL<Integer> list) {
		SLLNode<Integer> tmp = list.getFirst().succ;
		SLLNode<Integer> prev = list.getFirst();

		while (tmp != null) {
			if (prev.element == tmp.element) {
				list.delete(prev);
			}
			prev = tmp;
			tmp = tmp.succ;
		}
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

		SLL<Integer> result = mergeLists(list1, list2);
		System.out.println(result);
	}

}
