package Kol2;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SpojDLLDvaNacina {

	private static void mergeBothWays(DLL<Integer> lista1, DLL<Integer> lista2) {
		DLL<Integer> descending = new DLL<>();
		DLL<Integer> ascending = new DLL<>();

		DLLNode<Integer> last = lista1.getLast();
		DLLNode<Integer> first = lista2.getFirst();

		//First descending
		while (first != null && last != null)
			if (first.element > last.element) {
				descending.insertLast(first.element);
				ascending.insertFirst(first.element);
				first = first.succ;
			} else {
				descending.insertLast(last.element);
				ascending.insertFirst(last.element);
				last = last.pred;
			}

		while (first != null) {
			descending.insertLast(first.element);
			ascending.insertFirst(first.element);
			first = first.succ;
		}

		while (last != null) {
			descending.insertLast(last.element);
			ascending.insertFirst(last.element);
			last = last.pred;
		}

		System.out.println(descending);
		System.out.println(ascending);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DLL<Integer> lista1 = new DLL<>();
		DLL<Integer> lista2 = new DLL<>();
		int N = input.nextInt();
		IntStream.range(0, N).mapToObj(i -> input.nextInt()).forEach(lista1::insertLast);
		int M = input.nextInt();
		IntStream.range(0, M).mapToObj(i -> input.nextInt()).forEach(lista2::insertLast);

		mergeBothWays(lista1, lista2);
	}

}
