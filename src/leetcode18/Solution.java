package leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int length = nums.length;
    int pre_i = Integer.MAX_VALUE;
    for (int i = 0; i < length - 3; i++) {
      if (pre_i == nums[i]) {
        continue;
      }
      pre_i = nums[i];
      if (4 * nums[i] > target) {
        break;
      }
      if (nums[i] + 3 * nums[i + 1] > target || nums[i] + 3 * nums[length - 1] < target) {
        continue;
      }
      for (int j = i + 1; j < length - 2; j++) {
        if (j > i + 1 && nums[j - 1] == nums[j]) {
          continue;
        }
        int m = j + 1;
        int n = length - 1;
        int sub_target = target - nums[i] - nums[j];
        while (m < n) {
          if (nums[m] + nums[n] == sub_target) {
            Integer[] temp = {nums[i], nums[j], nums[m], nums[n]};
            result.add(Arrays.asList(temp));
            while (++m < n && nums[m] == nums[m - 1]);
            while (m < --n && nums[n] == nums[n + 1]);
          } else if (nums[m] + nums[n] < sub_target) {
            while (++m < n && nums[m] == nums[m - 1]);
          } else {
            while (m < --n && nums[n] == nums[n + 1]);
          }
        }
      }
    }
    return result;
  }
}
