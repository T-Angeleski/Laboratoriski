package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PalindromeSLL {

	private static boolean isPalindrome(SLL<Integer> list) {
		//Find middle
		SLLNode<Integer> fast = list.getFirst();
		SLLNode<Integer> slow = list.getFirst();

		while (fast != null && fast.succ != null) {
			fast = fast.succ.succ;
			slow = slow.succ;
		}

		//Reverse
		SLLNode<Integer> middle = slow;
		SLLNode<Integer> prev = null;
		SLLNode<Integer> next;

		while (middle != null) {
			next = middle.succ;
			middle.succ = prev;
			prev = middle;
			middle = next;
		}


		//Check
		SLLNode<Integer> first = list.getFirst();
		while (first != null && prev != null) {
			if (first.element != prev.element) return false;
			first = first.succ;
			prev = prev.succ;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		System.out.println(isPalindrome(list));
	}
}
