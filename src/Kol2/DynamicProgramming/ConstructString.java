package Kol2.DynamicProgramming;

import java.util.HashMap;

public class ConstructString {
	/*
	Given target string and array of strings
	Return T/F whether you can construct
	*/
//	private static boolean canConstruct(String target, String[] bank) {
//		if (target.isEmpty()) return true;
//		//Prefix, cut down target
//
//		for (String word : bank) {
//			//If substring is a prefix
//			if (target.indexOf(word) == 0) {
//				String afterRemoval = target.substring(word.length());
//
//				//true on first found
//				if (canConstruct(afterRemoval, bank)) return true;
//			}
//		}
//		return false;//After trying all possible choices, false
//	}

	private static boolean canConstruct(String target, String[] bank, HashMap<String, Boolean> memo) {
		if (memo.containsKey(target)) return memo.get(target);
		if (target.isEmpty()) return true;
		//Prefix, cut down target

		for (String word : bank) {
			//If substring is a prefix
			if (target.indexOf(word) == 0) {
				String afterRemoval = target.substring(word.length());

				//true on first found
				if (canConstruct(afterRemoval, bank, memo)) {
					memo.put(target, true);
					return true;
				}
			}
		}
		memo.put(target, false);
		return false;//After trying all possible choices, false
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("abcdef",
				new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
		System.out.println(canConstruct("skateboard",
				new String[]{"bo", "rd", "ate", "t", "ska",
						"sk", "boar"}, new HashMap<>()));
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
	}


}
