package leetcode414;

public class Solution {
  public int thirdMax(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    } else if (n == 2) {
      return Math.max(nums[0], nums[1]);
    }

    long n1 = Long.MIN_VALUE, n2 = Long.MIN_VALUE, n3 = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (nums[i] > n3) {
        n1 = n2;
        n2 = n3;
        n3 = (long) nums[i];
      } else if (nums[i] > n2 && nums[i] < n3) {
        n1 = n2;
        n2 = (long) nums[i];
      } else if (nums[i] > n1 && nums[i] < n2) {
        n1 = (long) nums[i];
      }
    }
    if (n1 == Long.MIN_VALUE) {
      return (int) n3;
    } else {
      return (int) n1;
    }
  }
}
