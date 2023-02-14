package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class DeleteEvenPojavuvanja {
	//Izbrisi jazli cii vrednosti se javuvaat paren broj pati
	//Dozvoleno e samo edna lista
	public static void deleteEven(SLL<Integer> list) {
		SLLNode<Integer> tmp = list.getFirst();
		SLLNode<Integer> current;
		int counter;
		while (tmp != null) {
			counter = 0;
			current = list.getFirst();

			//Count occurences
			while (current != null) {
				if (current.element.equals(tmp.element))
					++counter;
				current = current.succ;
			}

			if (counter % 2 == 0) {
				SLLNode<Integer> toDelete = tmp;
				while (toDelete != null) {
					if (toDelete.element == tmp.element)
						list.delete(toDelete);
					toDelete = toDelete.succ;
				}
			}

			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Integer> list = new SLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list::insertLast);
		deleteEven(list);
		System.out.println(list);
	}
}
