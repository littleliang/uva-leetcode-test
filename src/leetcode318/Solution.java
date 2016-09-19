package leetcode318;

public class Solution {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int len = words.length;
		int[] num = new int[len];
		int maxProduct = 0;
		for (int i = 0; i < len; i++) {
			String temp = words[i];
			for (int j = 0; j < temp.length(); j++) {
				num[i] |= (1 << (temp.charAt(j) - 'a'));
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((num[i] & num[j]) == 0) {
					int temp = words[i].length() * words[j].length();
					if (temp > maxProduct)
						maxProduct = temp;
				}
			}
		}
		return maxProduct;
	}
}
