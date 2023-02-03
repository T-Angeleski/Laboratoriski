package Kol2;

import DadeniKodovi.Kodovi.CBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SantaHelpers {

	/* Помошниците на Дедо Мраз направиле компјутерски систем
	во кој се чуваа список на сите добри деца и
	нивната желба за подарок за Нова Година,
	само што за македонските деца употребиле
	стара транскрипција на специфичните македонски букви,
	па така буквата ч ја чуваат како c,
	буквата ж како z и ш како s.
	Но, кога треба да проверат дали некое дете било добро,
	неговото име го добиваат според новата
	транскрипција каде буквата
	ч се преставува како ch,
	буквата ж како zh и ш како sh.
	Помогнете им на помошниците на
	Дедо Мраз да проверат дали детете било добро ,
	и доколку било, кој подарок треба да го добие.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		CBHT<String, String> presentsByKids = new CBHT<>(2 * n);
		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split(" ");
			String name = parts[0];
			String present = parts[1];

			presentsByKids.insert(name, present);
		}

		String kid = br.readLine();
		String kidFiltered = filterName(kid);

		if (presentsByKids.search(kidFiltered) == null) {
			System.out.println("Nema poklon");
		} else {
			String present = presentsByKids.search(kidFiltered).element.value;
			System.out.println(present);
		}


	}

	private static String filterName(String name) {
		// s sh c ch z zh
		for (int i = 1; i < name.length(); i++) {
			char c = name.toLowerCase().charAt(i);
			char prev = name.toLowerCase().charAt(i - 1);
			if (c == 'h') {
				if (prev == 's' || prev == 'c' || prev == 'z') {
					int toDeleteIndex = name.indexOf(c);
					String substring1 = name.substring(0, toDeleteIndex);
					String substring2 = name.substring(toDeleteIndex + 1);
					name = String.format("%s%s", substring1, substring2);
					--i;
				}
			}
		}
		return name;
	}
}
