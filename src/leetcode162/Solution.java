package leetcode162;

public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums == null) {
      return -1;
    } else if (nums.length == 0) {
      return -1;
    } else if (nums.length == 1) {
      return 0;
    }
    int left = 0;
    int mid = 0;
    int right = nums.length - 1;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
