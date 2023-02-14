package Kol2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DoubleDLLProduct {


	private static long calculateProduct(DLL<DLL<Integer>> list) {
		List<Integer> sums = new ArrayList<>();
		DLLNode<DLL<Integer>> bigList = list.getFirst();
		int sum;
		while (bigList != null) {
			DLLNode<Integer> inner = bigList.element.getFirst();
			sum = 0;
			while (inner != null) {
				sum += inner.element;
				inner = inner.succ;
			}
			sums.add(sum);
			bigList = bigList.succ;
		}
		return sums.stream()
				.mapToLong(integer -> integer)
				.reduce(1, (a, b) -> a * b);
	}

	public static void main(String[] args) {
		DLL<DLL<Integer>> list = new DLL<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		IntStream.range(0, n).<DLL<Integer>>mapToObj(i -> new DLL<>()).forEach(tmp -> {
			IntStream.range(0, m).mapToObj(j -> sc.nextInt()).forEach(tmp::insertLast);
			list.insertLast(tmp);
		});

		System.out.println(calculateProduct(list));
	}

}
