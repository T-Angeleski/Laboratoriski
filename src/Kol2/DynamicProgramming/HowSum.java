package Kol2.DynamicProgramming;


public class HowSum {

	/*
	Given an integer array of coins[ ] of size N
	representing different types of currency
	and an integer sum,
	The task is to find the number of ways to make sum
	by using different combinations from coins[].
	Note: Assume that you have an infinite
	supply of each type of coin.
	*/

	private static int howSum(int target, int[] coins, int n) {
		if (target == 0) return 1;
		if (target < 0) return 0;
		if (n <= 0) return 0;

		return howSum(target, coins, n - 1) + howSum(target - coins[n - 1], coins, n);
	}

	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		int n = coins.length;
		System.out.println(howSum(4, coins, n));
	}

}
