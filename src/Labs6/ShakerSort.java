package Labs6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

	private static void printArray(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print(a[n - 1] + "\n");
	}

	static void shakerSort(int[] a, int n) {
		// Vasiot kod tuka
		boolean flag = true;
		int endLimit = n - 1;
		int startLimit = 0;

		for (int count = 0; flag; count++) {
			flag = false;
			//Shift smallest to start

			for (int i = endLimit; i > startLimit; i--) {

				if (a[i] < a[i - 1]) { //found swap, not Sorted
					int tmp = a[i - 1];
					a[i - 1] = a[i];
					a[i] = tmp;
					flag = true;
				}
			}
			printArray(a, n);

			//Shift largest to end
			for (int i = startLimit; i < endLimit; i++) {
				if (a[i] > a[i + 1]) {
					int tmp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = tmp;
					flag = true;
				}
			}
			printArray(a, n);
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
		shakerSort(a, n);
	}
}