package Kol2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JoinDLLSorted {
	private static DLL<Integer> joinLists(DLL<Integer> list1, DLL<Integer> list2) {
		DLLNode<Integer> last = list1.getLast();
		DLLNode<Integer> first = list2.getFirst();

		DLL<Integer> result = new DLL<>();

		while (last != null && first != null) {
			if (first.element > last.element) {
				result.insertLast(first.element);
				first = first.succ;
			} else {
				result.insertLast(last.element);
				last = last.pred;
			}
		}

		while (last != null) {
			result.insertLast(last.element);
			last = last.pred;
		}

		while (first != null) {
			result.insertLast(first.element);
			first = first.succ;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		DLL<Integer> list1 = new DLL<>();
		DLL<Integer> list2 = new DLL<>();
		for (int i = 0; i < n; i++) {
			list1.insertLast(sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			list2.insertLast(sc.nextInt());
		}

		DLL<Integer> result = joinLists(list1, list2);
		System.out.println(result);
	}

}
