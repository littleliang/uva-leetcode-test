package leetcode290;

import java.util.HashMap;

public class Solution {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<>();
		HashMap<String, Character> mapOther = new HashMap<>();
		String[] strArray = str.split(" ");
		if (pattern.length() != strArray.length) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				map.put(pattern.charAt(i), strArray[i]);
			} else {
				if (!strArray[i].equals(map.get(pattern.charAt(i)))) {
					return false;
				}
			}

			if (!mapOther.containsKey(strArray[i])) {
				mapOther.put(strArray[i], pattern.charAt(i));
			} else {
				if (pattern.charAt(i) != mapOther.get(strArray[i])) {
					return false;
				}
			}

		}
		return true;
	}
}
