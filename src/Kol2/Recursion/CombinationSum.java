package Kol2.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	private void combinationSumRecursive(int index, int[] array, int target,
	                                     List<List<Integer>> answer, List<Integer> struct) {
		if (index == array.length) {
			if (target == 0) answer.add(new ArrayList<>(struct));
			return;
		}

		if (array[index] <= target) {
			struct.add(array[index]);
			combinationSumRecursive(index, array, target - array[index], answer, struct);
			struct.remove(struct.size() - 1);
		}
		combinationSumRecursive(index + 1, array, target, answer, struct);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<>();
		combinationSumRecursive(0, candidates, target, answer, new ArrayList<>());
		return answer;
	}

	public static void main(String[] args) {

	}
}
