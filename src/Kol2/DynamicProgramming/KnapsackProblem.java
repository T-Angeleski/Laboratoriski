package Kol2.DynamicProgramming;

public class KnapsackProblem {

	private static int knapsackDynamic(int[] weights, int[] p, int C) {
		int n = weights.length;
		int[][] dp = new int[n + 1][C + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;
		for (int j = 0; j <= C; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= n; i++)
			//j - objektite
			//0 indexed se w i p
			for (int j = 1; j <= C; j++)
				if (weights[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]]);
				} else { //ne go sobira
					dp[i][j] = dp[i - 1][j];
				}

		return dp[n][C];
	}

	public static void main(String[] args) {
		int C = 50;
		int p[] = {60, 100, 120}; //profits
		int w[] = {10, 20, 30}; //weights
		System.out.println(knapsackDynamic(w, p, C));
	}

}
