package Kol2;


import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Во оваа игра на
 * располагање имате топчиња во три различни бои
 * (R-црвена, G-зелена и B-сина),
 * обележани со знакот + или -.
 * Поништување на топчиња може да настане само доколку
 * тие се од иста боја и со спротивен знак.
 * Ваша задача е од влез, како доаѓаат топчињата да направите
 * поништување и да кажете колку,
 * од каков тип (+ или -) и од која боја фалат за да се
 * поништат сите топчиња од влезот
 * INPUT
 * R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
 * OUTPUT
 * 4
 * R- G- G- B-
 */
public class PonishtuvanjeTopcinja {

	public static void pairsLeft(String[] balls) {
		SLL<String> ballsList = new SLL<>();
		for (String ball : balls) {
			ballsList.insertLast(ball);
		}

		SLLNode<String> tmp = ballsList.getFirst();
		boolean flag = false;
		while (tmp != null) {
			SLLNode<String> tmp2 = tmp.succ;
			while (tmp2 != null) {
				if (tmp.element.charAt(0) == tmp2.element.charAt(0)) {
					if (tmp.element.charAt(1) != tmp2.element.charAt(1)) {
						ballsList.delete(tmp);
						ballsList.delete(tmp2);
						tmp = ballsList.getFirst();
						flag = true;
						break;
					}
				}
				flag = false;
				tmp2 = tmp2.succ;
			}
			if (!flag) tmp = tmp.succ;

		}

		//Find pairs from missing
		SLL<String> result = new SLL<>();
		tmp = ballsList.getFirst();
		while (tmp != null) {
			char color = tmp.element.charAt(0);
			char sign = tmp.element.charAt(1);
			char missingSign = sign == '+' ? '-' : '+';

			result.insertLast(String.format("%c%c", color, missingSign));
			tmp = tmp.succ;
		}


		System.out.println(ballsList.getLength());
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		pairsLeft(input);
	}
}
