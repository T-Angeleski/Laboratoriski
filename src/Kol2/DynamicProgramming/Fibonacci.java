package Kol2.DynamicProgramming;

import java.util.HashMap;

public class Fibonacci {
	/*
    O(2^n)
	public static int fibonacci(int n) {
		if (n <= 2) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
*/

	//Memoization
	// <k,v>  Argument, Value
	//O(n)
	public static int fibonacci(int n, HashMap<Integer, Integer> map) {
		if (map.containsKey(n)) return map.get(n);
		if (n <= 2) return 1;
		map.put(n, fibonacci(n - 1, map) + fibonacci(n - 2, map));
		return map.get(n);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(6, new HashMap<>()));
	}
}
