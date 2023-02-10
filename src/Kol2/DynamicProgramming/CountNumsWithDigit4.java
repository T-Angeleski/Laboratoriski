package Kol2.DynamicProgramming;

public class CountNumsWithDigit4 {

	static boolean[] dp = new boolean[1000];

	static boolean hasDigit(int n) {
		if (n == 0) return false;
		if (n % 10 == 4) {
			dp[n] = true;
			return true;
		} else dp[n] = false;

		return dp[n] = hasDigit(n / 10);
	}

	static int countNumberswith4(int n) {
		int count = 0;

		for (int i = 4; i <= n; i++) {
			if (hasDigit(i)) ++count;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countNumberswith4(50));
	}
}
