package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class RazigranaListaDLL {

	//Od pocetok to kraj brisi sekoj vtor
	//Pa od kraj do pocetok brisi sekoj vtor
	//Se dodeka ne ostane 1 element
	public static void razigraj(DLL<String> lista) {
		while (lista.length() != 1) {
			// ->
			if (lista.length() == 1)
				return;

			for (DLLNode<String> tmp = lista.getFirst().succ;
			     tmp != null;
			     tmp = tmp.succ.succ) {

				lista.delete(tmp);
				if (tmp.succ == null)
					break;

			}
			if (lista.length() == 1)
				return;

			for (DLLNode<String> tmp = lista.getLast().pred;
			     tmp != null;
			     tmp = tmp.pred.pred) {

				lista.delete(tmp);
				if (tmp.pred == null)
					break;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DLL<String> lista = new DLL<String>();
		String[] str = br.readLine().split(" ");        // a b c d e f g h i j
		Arrays.stream(str).forEach(lista::insertLast);
		razigraj(lista);
		System.out.println(lista);
	}
}
