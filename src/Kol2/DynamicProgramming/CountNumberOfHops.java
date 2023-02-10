package Kol2.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class CountNumberOfHops {
	//Function to count the number of ways in which frog can reach the top.
	static long countWays(int n) {
		long[] dp = new long[n + 1];
		int modulo = 1000000007;
		Arrays.fill(dp, -1);
		return countWaysRecursive(n, new int[]{1, 2, 3}, dp) % modulo;
	}

	private static long countWaysRecursive(int n, int[] ways, long[] dp) {
		if (n == 0) return 1;
		if (n < 0) return 0;

		if (dp[n] != -1) return dp[n];
		else dp[n] = countWaysRecursive(n - ways[0], ways, dp) +
				countWaysRecursive(n - ways[1], ways, dp) +
				countWaysRecursive(n - ways[2], ways, dp);
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(countWays(80));
	}
}
