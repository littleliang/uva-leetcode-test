package leetcode219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length < 2)
      return false;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int j = map.get(nums[i]);
        if (i - j <= k) {
          return true;
        } else {
          map.put(nums[i], i);
        }
      } else {
        map.put(nums[i], i);
      }
    }
    return false;
  }
}
