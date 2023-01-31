package Kol2;

import DadeniKodovi.Kodovi.ArrayStack;
import DadeniKodovi.Kodovi.Stack;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class BukviStack {
	static int proveri_t_posle_s(char[] st) {
		Stack<Character> bukviStack = new ArrayStack<>(100);
		int total = 0;
		boolean flag = true;
		for (char c : st) {
			if (c == 'S' && bukviStack.isEmpty()) {
				bukviStack.push(c);
			}

			if (c == 'T') bukviStack.push(c);

			if (c == 'S') {
				//Clear all stack and count how many T's
				bukviStack.push(c);
				int count = 0;
				while (!bukviStack.isEmpty()) {
					if (bukviStack.peek() == 'T') {
						++count;
					}
					bukviStack.pop();
				}
				if (flag) {
					total = count;
					flag = false;
				} else {
					if (count != total) return 0;
				}
			}
		}



		return 1;
	}

	public static void main(String[] args) throws IOException {
		char[] niza = new char[100];

		Scanner f = new Scanner(System.in);
		String st = f.next();
		niza = st.toCharArray();

		int rez = proveri_t_posle_s(niza);
		System.out.println(rez);
	}


}
