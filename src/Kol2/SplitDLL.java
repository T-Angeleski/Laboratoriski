package Kol2;

/*
Na vlez e dadena edna edinecno povrzana lista sostavena od
info pole koe e char vrednost.
	Da se napravat dve posebni dvojno povrzani
	listi vo koi vo ednata ke se prefrlat
	jazlite koi imaat samoglaska vo nivnata
	vrednost a vo drugata listata jazlite koi
	imaat soglaska.
*/

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.util.Scanner;

public class SplitDLL {
	private static void splitDLL(SLL<Character> listOriginal, SLL<Character> listSoglaski, SLL<Character> listSamoglaski) {
		SLLNode<Character> tmp = listOriginal.getFirst();
		while (tmp != null) {
			if (tmp.element == 'a' || tmp.element == 'e' ||
					tmp.element == 'i' || tmp.element == 'o' ||
					tmp.element == 'u') {
				listSamoglaski.insertLast(tmp.element);
			} else listSoglaski.insertLast(tmp.element);

			tmp = tmp.succ;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SLL<Character> listOriginal = new SLL<>();
		for (int i = 0; i < 12; i++) {
			String next = sc.next();
			char c = next.charAt(0);
			listOriginal.insertLast(c);
		}

		SLL<Character> listSoglaski = new SLL<>();
		SLL<Character> listSamoglaski = new SLL<>();

		splitDLL(listOriginal, listSoglaski, listSamoglaski);
		System.out.println(listSoglaski);
		System.out.println(listSamoglaski);
	}

}
