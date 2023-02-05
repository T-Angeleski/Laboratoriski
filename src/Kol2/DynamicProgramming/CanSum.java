package Kol2.DynamicProgramming;

/*
Given a target sum and an array of integers
return whether that sum can be reached using given array
Can use numbers multiple times
*/

import java.util.HashMap;

public class CanSum {

/*
	public static boolean canSum(int targetSum, int[] numbers) {
		if (targetSum == 0) return true;
		if (targetSum < 0) return false;

		for (int number : numbers) {
			int remainder = targetSum - number;
			if (canSum(remainder, numbers)) return true; // If possible, return true
		}
		return false;
	}
*/

	//K ->  targetsum V -> T/F
	public static boolean canSum(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		if (targetSum == 0) return true;
		if (targetSum < 0) return false;

		for (int number : numbers) {
			int remainder = targetSum - number;
			if (canSum(remainder, numbers, memo)) {
				memo.put(targetSum, true);
				return true; // If possible, return true
			}
		}
		memo.put(targetSum, false);
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canSum(7, new int[]{2, 3}, new HashMap<>()));
		System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
		System.out.println(canSum(7, new int[]{2, 4}, new HashMap<>()));
		System.out.println(canSum(8, new int[]{2, 3, 5}, new HashMap<>()));
		System.out.println(canSum(300, new int[]{7, 14}, new HashMap<>()));
	}
}
