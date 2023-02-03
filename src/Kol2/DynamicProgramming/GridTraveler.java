package Kol2.DynamicProgramming;


/*
You are a traveler on a 2D grid
you begin in the top left corner and your goal
is to travel to the bottom right corner
You may only move down or right
In how many ways can you travel to the goal
with an m*n grid?
*/

import java.util.HashMap;

public class GridTraveler {
	/*
Brute force recursion method O(2^ m+n)
	public static int gridTraveler(int m, int n) {
		if (m == 1 && n == 1) return 1;
		if (m == 0 || n == 0) return 0; // Empty grid, no way
		return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
	}
*/
	public static int gridTraveler(int m, int n, HashMap<String, Integer> memo) {
		String key = m + "," + n;
		if (memo.containsKey(key)) return memo.get(key);
		if (m == 1 && n == 1) return 1;
		if (m == 0 || n == 0) return 0; // Empty grid, no way

		memo.put(key, gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo));
		return memo.get(key);
	}

	public static void main(String[] args) {
		System.out.println(gridTraveler(1, 1, new HashMap<>()));
		System.out.println(gridTraveler(2, 3, new HashMap<>()));
		System.out.println(gridTraveler(3, 2, new HashMap<>()));
		System.out.println(gridTraveler(3, 3, new HashMap<>()));
		System.out.println(gridTraveler(12, 12, new HashMap<>()));
	}
}
