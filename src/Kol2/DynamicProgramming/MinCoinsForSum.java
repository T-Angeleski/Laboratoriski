package Kol2.DynamicProgramming;

import java.util.Arrays;

public class MinCoinsForSum {
	public static int MAX_SUM = 1000;

	public static int[] minNumCoinsForSum(int n, int[] coins) {
		int[] numCoinsForSum = new int[MAX_SUM + 1]; // index 0 to be 0

		Arrays.fill(numCoinsForSum, 0);
		//Mora da pocneme od negde
		//num[5] = 1 ---> sekogas najdobro e so dadeni coins
		for (int i = 0; i < n; i++) {
			numCoinsForSum[coins[i]] = 1;
		}

		//Za sekoja suma, vidi site kombinacii na pari
		for (int i = 0; i <= MAX_SUM; i++) {
			//Za sekoja para
			for (int j = 0; j < n; j++) {

				if (i + coins[j] <= MAX_SUM) {
					if (numCoinsForSum[i + coins[j]] == 0 ||//prv pat taa suma
							numCoinsForSum[i + coins[j]] > numCoinsForSum[i] + 1) { //Povekje pari odkolku sega
						numCoinsForSum[i + coins[j]] = numCoinsForSum[i] + 1;
						//Kolku sho sme imale pari do sega, plus novata suma
					}
				}

			}
		}
		return numCoinsForSum;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] coints = {1, 2, 5, 8, 10};
		System.out.println(minNumCoinsForSum(n, coints)[13]); //Min pari za suma 13
		System.out.println(minNumCoinsForSum(n, coints)[15]);
		System.out.println(minNumCoinsForSum(n, coints)[21]);
	}
}
