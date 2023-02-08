package Kol2.DynamicProgramming;


/*
You are a traveler on a 2D grid
you begin in the top left corner and your goal
is to travel to the bottom right corner
You may only move down or right
In how many ways can you travel to the goal
with an m*n grid?
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

	public static long gridTravelerT(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		//Fill 0s
		for (int i = 0; i <= m; i++) for (int j = 0; j <= n; j++) dp[i][j] = 0;
		dp[1][1] = 1;

		//Add current to bottom and right neighbour
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				if (j + 1 <= n) dp[i][j + 1] += dp[i][j];
				if (i + 1 <= m) dp[i + 1][j] += dp[i][j];
			}

		return dp[m][n];
	}


	public static void main(String[] args) {
		System.out.println(gridTraveler(1, 1, new HashMap<>()));
		System.out.println(gridTraveler(2, 3, new HashMap<>()));
		System.out.println(gridTraveler(3, 2, new HashMap<>()));
		System.out.println(gridTraveler(3, 3, new HashMap<>()));
		System.out.println(gridTraveler(12, 12, new HashMap<>()));

		System.out.println(gridTravelerT(1, 1));
		System.out.println(gridTravelerT(2, 3));
		System.out.println(gridTravelerT(3, 2));
		System.out.println(gridTravelerT(3, 3));
		System.out.println(gridTravelerT(16, 16));
	}
}
