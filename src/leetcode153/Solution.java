package leetcode153;

public class Solution {
	public int findMin(int[] num) {
		if (num == null || num.length < 1)
			return 0;

		int low = 0, high = num.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int x = num[mid];
			if (mid != num.length - 1 && x > num[mid + 1]) {
				return num[mid + 1];
			} else if (num[mid] < num[low]) {
				high = mid;
			} else if (num[mid] > num[high]) {
				low = mid;
			} else {
				return num[low];
			}
		}
		return num[low];
	}
}
