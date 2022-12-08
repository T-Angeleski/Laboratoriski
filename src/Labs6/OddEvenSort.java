package Labs6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

	static void oddEvenSort(int[] a, int n) {
		//Get num of odd elements
		int odd = 0;
		for (int i : a) {
			if (i % 2 != 0) odd++;
		}

		//First #odd indexes are for odd elements, then even
		//Swap them

		for (int i = 0; i < odd; i++) {

			if (a[i] % 2 == 0) {
				//swap it out
				for (int j = odd; j < n; j++)
					if (a[j] % 2 == 1) {
						int tmp = a[i];
						a[i] = a[j];
						a[j] = tmp;
						break;
					}
			}
		}

		//Now sort both parts
		for (int i = 0; i < odd - 1; i++) {
			for (int j = 0; j < odd - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}

		for (int i = odd; i < n - 1; i++) {
			for (int j = odd; j < n - 1; j++) {
				if (a[j] < a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		int i;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s = stdin.readLine();
		int n = Integer.parseInt(s);

		s = stdin.readLine();
		String[] pom = s.split(" ");
		int[] a = new int[n];
		for (i = 0; i < n; i++)
			a[i] = Integer.parseInt(pom[i]);
		oddEvenSort(a, n);
		for (i = 0; i < n - 1; i++)
			System.out.print(a[i] + " ");
		System.out.print(a[i]);
	}
}