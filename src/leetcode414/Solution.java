package leetcode414;

public class Solution {
  public int thirdMax(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    } else if (n == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int n1 = Math.min(nums[0], Math.min(nums[1], nums[2])),
        n2 = Math.max(nums[0], Math.min(nums[1], nums[2])),
        n3 = Math.max(nums[0], Math.max(nums[1], nums[2]));
    for (int i = 3; i < n; i++) {
      if (nums[i] > n3) {
        n1 = n2;
        n2 = n3;
        n3 = nums[i];
      } else if (nums[i] >= n2) {
        n2 = nums[i];
      } else if (nums[i] > n1) {
        n1 = nums[i];
      }
    }
    return n1;
  }
}
