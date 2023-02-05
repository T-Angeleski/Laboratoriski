package Kol2.Recursion;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Strukturno {

	public static void isExponent(InputStream is) {
		//If first number is exponent of second
		Scanner sc = new Scanner(is);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(isExponentRecursive(a, b));
	}

	//16, 2 true   7, 2 false
	private static boolean isExponentRecursive(int a, int b) {
		if (a == 0) return false;
		if (a == b) return true;
		return isExponentRecursive(a / b, b);
	}

	public static void numberOccurences(InputStream is) {
		Scanner sc = new Scanner(is);
		long bigNum = sc.nextInt();
		int num = sc.nextInt();

		int numDigits = 0;
		while (num > 0) {
			++numDigits;
			num /= 10;
		}

		System.out.println(numberOccurencesRecursive(bigNum, num, numDigits));
	}

	private static int numberOccurencesRecursive(long bigNum, int num, int numDigits) {
		if (bigNum == 0) return 0;
		int remainder = (int) (bigNum % numDigits);

		if (remainder == num) return 1 + numberOccurencesRecursive(bigNum / 10, num, numDigits);
		else return numberOccurencesRecursive(bigNum / 10, num, numDigits);
	}

	public static void numberOddEvenDigits(InputStream is) {
		Scanner sc = new Scanner(is);
		int number = sc.nextInt();

		int[] overcomplicate = new int[2];
		numberOddEvenDigitsR(number, overcomplicate);
		System.out.printf("%d even and %d odd digits in number %d", overcomplicate[0], overcomplicate[1], number);
	}

	private static int[] numberOddEvenDigitsR(int number, int[] array) {
		if (number != 0) {
			if ((number % 10) % 2 == 0) array[0]++;
			else array[1]++;
			return numberOddEvenDigitsR(number / 10, array);
		} else return array;
	}

	public static void reverseArray(InputStream is) {
		Scanner sc = new Scanner(is);
		int n = sc.nextInt();
		int[] array = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();

		int[] result = reverseArrayR(array, n, 0);
		System.out.println(Arrays.toString(result));
	}

	private static int[] reverseArrayR(int[] array, int n, int i) {
		if ((2 * i) < n) {
			int tmp = array[i];
			array[i] = array[n - i - 1];
			array[n - i - 1] = tmp;

			return reverseArrayR(array, n, i + 1);
		} else return array;
	}

	public static void main(String[] args) {
//		isExponent(System.in);
//		numberOccurences(System.in);
//		numberOddEvenDigits(System.in);
		reverseArray(System.in);
	}

}
