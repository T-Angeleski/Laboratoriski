package Kol2;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
Од овие две листи треба да се креира нова двострано поврзана листа,
на тој начин што јазлите ќе се додаваат наизменично и тоа само оние со парни броеви
(прв елемент од првата листа (ако е парен), последен од втората (ако е парен), втор елемент од првата листа (ако е парен), претпоследен од втората (ако е парен) итн.).
Јазлите со парни броеви кои ќе останат треба да се додадат на крај во резултантната листа.
 Потоа на резултантната листа се додаваат само преостанатите јазли со непарни елементи од првата
листа и преостанатите јазли со непарни елементи но во обратен редослед од втората листа.
*/

public class SpojDLLNaizmenicnoParnost {

	private static DLL<Integer> combineLists(DLL<Integer> list1, DLL<Integer> list2) {
		DLLNode<Integer> first = list1.getFirst();
		DLLNode<Integer> second = list2.getLast();
		DLL<Integer> result = new DLL<>();


		while (first != null && second != null) {
			if (first.element % 2 == 0 && second.element % 2 == 0) {
				result.insertLast(first.element);
				result.insertLast(second.element);
			} else if (first.element % 2 == 0) {
				result.insertLast(first.element);
			} else if (second.element % 2 == 0) {
				result.insertLast(second.element);
			}
			first = first.succ;
			second = second.pred;
		}

		//Ostanati parni
		while (first != null) {
			if (first.element % 2 == 0)
				result.insertLast(first.element);
			first = first.succ;
		}

		while (second != null) {
			if (second.element % 2 == 0)
				result.insertLast(second.element);
			second = second.pred;
		}

		//Dodadi ostanati neparni no obratno
		first = list1.getFirst();
		second = list2.getLast();

		while (first != null) {
			if (first.element % 2 != 0)
				result.insertLast(first.element);
			first = first.succ;
		}

		while (second != null) {
			if (second.element % 2 != 0)
				result.insertLast(second.element);
			second = second.pred;
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DLL<Integer> list1 = new DLL<>();
		DLL<Integer> list2 = new DLL<>();
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(list1::insertLast);

		int m = sc.nextInt();
		IntStream.range(0, m).mapToObj(i -> sc.nextInt()).forEach(list2::insertLast);

		DLL<Integer> result = combineLists(list1, list2);
		System.out.println(result);
	}

}
