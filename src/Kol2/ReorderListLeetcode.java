package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ReorderListLeetcode {
	/*
	You are given the head of a singly linked-list.
	The list can be represented as:
	L0 → L1 → … → Ln - 1 → Ln
	Reorder the list to be on the following form:
	L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
	*/

	//O(N) time O(1) memory
	private static void orderList(SLL<Integer> list) {
		//Get middle of list
		SLLNode<Integer> slow = list.getFirst();
		SLLNode<Integer> fast = list.getFirst();
		while (fast != null && fast.succ != null) {
			slow = slow.succ;
			fast = fast.succ.succ;
		}

		//Slow is second
		SLLNode<Integer> second = slow.succ;
		slow.succ = null;

		//Reverse second half of list
		SLLNode<Integer> prev = null;
		while (second != null) {
			SLLNode<Integer> tmp = second.succ;
			second.succ = prev;
			prev = second;
			second = tmp;
		}

		//Merge 2 halves
		second = prev;
		SLLNode<Integer> first = list.getFirst();

		while (second != null) {
			SLLNode<Integer> tmp1 = first.succ;
			SLLNode<Integer> tmp2 = second.succ;

			first.succ = second;
			second.succ = tmp1;
			first = tmp1;
			second = tmp2;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		orderList(list);
		System.out.println(list);
	}


}
