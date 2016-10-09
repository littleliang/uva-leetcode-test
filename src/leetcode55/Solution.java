package leetcode55;

public class Solution {
  public boolean canJump(int[] nums) {
    int maxCanReach = nums[0];
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxCanReach) {
        return false;
      }
      temp = nums[i] + i;
      if (temp > maxCanReach) {
        maxCanReach = temp;
      }
      if (maxCanReach >= nums.length - 1) {
        return true;
      }
    }
    return true;
  }
}
