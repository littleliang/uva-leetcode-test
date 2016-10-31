package leetcode327;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
  public int countRangeSum(int[] nums, int lower, int upper) {
    TreeMap<Long, Integer> treeMap = new TreeMap<Long, Integer>();
    int result = 0;
    long sum = 0;
    treeMap.put(sum, 1);
    for (int n : nums) {
      sum += n;
      Map<Long, Integer> map = treeMap.subMap(sum - upper, true, sum - lower, true);
      for (int i : map.values())
        result += i;
      if (!treeMap.containsKey(sum))
        treeMap.put(sum, 0);
      treeMap.put(sum, treeMap.get(sum) + 1);
    }
    return result;
  }
}
