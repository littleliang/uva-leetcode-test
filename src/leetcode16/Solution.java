package leetcode16;

import java.util.Arrays;

public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int len = nums.length, closeTarget = 0, minReduce = 0, total = 0, i = 0;
    Arrays.sort(nums);
    closeTarget = nums[0] + nums[1] + nums[2];
    minReduce = Math.abs(closeTarget - target);
    for (; i < len; i++) {
      int j = i + 1, k = len - 1;
      while (j < k) {
        total = nums[i] + nums[j] + nums[k];

        if (total > target) {
          k--;
        } else if (total < target) {
          j++;
        } else {
          return target;
        }
        if (minReduce > Math.abs(total - target)) {
          minReduce = Math.abs(total - target);
          closeTarget = total;
        }

      }
    }
    return closeTarget;
  }
}
