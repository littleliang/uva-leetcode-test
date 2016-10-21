package leetcode220;

import java.util.TreeSet;

public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length == 0 || k <= 0 || t < 0)
      return false;
    TreeSet<Long> tree = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Long ceil = tree.ceiling((long) nums[i] - t);
      Long floor = tree.floor((long) nums[i] + t);
      if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
        return true;
      if (tree.add((long) nums[i]) && i >= k)
        tree.remove((long) nums[i - k]);
    }
    return false;
  }
}
