package leetcode330;

public class Solution {
  public int minPatches(int[] nums, int n) {
    if (n <= 0)
      return 0;
    int index = 0;
    int ret = 0;
    long bound = 1;
    long sum = 0;
    while (bound <= n) {
      if (index < nums.length && nums[index] <= bound) {
        sum += nums[index++];
        bound = sum + 1;
      } else {
        ret++;
        sum += bound;
        bound = sum + 1;
      }
    }
    return ret;
  }
}
