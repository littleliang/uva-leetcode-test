package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  List<List<Integer>> ans = new ArrayList<List<Integer>>();

  public List<List<Integer>> threeSum(int[] nums) {
    int length = nums.length;
    if (nums == null || length < 3)
      return ans;
    Arrays.sort(nums);
    for (int i = 0; i < length - 2; ++i) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      findTwoSum(nums, i + 1, length - 1, nums[i]);
    }
    return ans;
  }

  public void findTwoSum(int[] num, int begin, int end, int target) {
    while (begin < end) {
      if (num[begin] + num[end] + target == 0) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(target);
        list.add(num[begin]);
        list.add(num[end]);
        ans.add(list);
        while (begin < end && num[begin + 1] == num[begin])
          begin++;
        begin++;
        while (begin < end && num[end - 1] == num[end])
          end--;
        end--;
      } else if (num[begin] + num[end] + target > 0)
        end--;
      else
        begin++;
    }
  }
}
