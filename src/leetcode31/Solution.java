package leetcode31;

public class Solution {
  public void nextPermutation(int[] nums) {
    int len = nums.length, i = len - 1, j, tmp;
    while (i > 0 && nums[i] <= nums[i - 1])
      i--;
    if (i > 0) {
      j = len - 1;
      while (nums[j] <= nums[i - 1])
        j--;
      tmp = nums[j];
      nums[j] = nums[i - 1];
      nums[i - 1] = tmp;
    }
    j = len - 1;
    while (i < j) {
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
      i++;
      j--;
    }
  }
}
