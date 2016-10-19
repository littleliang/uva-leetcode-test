package leetcode403;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
  public boolean canCross(int[] stones) {
    if (stones == null || stones.length == 0) {
      return false;
    }
    if (stones[1] != 1) {
      return false;
    }
    if (stones[stones.length - 1] + 1 == stones.length) {
      return true;
    }
    List<HashSet<Integer>> dp = new ArrayList<HashSet<Integer>>();
    HashSet<Integer> set1 = new HashSet<Integer>();
    set1.add(0);
    dp.add(set1);
    HashSet<Integer> set2 = new HashSet<Integer>();
    set2.add(1);
    dp.add(set2);
    for (int i = 2; i < stones.length; i++) {
      int des = stones[i];
      HashSet<Integer> res = new HashSet<Integer>();
      for (int j = 0; j < i; j++) {
        int start = stones[j];
        int dis = des - start;
        HashSet<Integer> t = dp.get(j);
        if (t.contains(dis - 1) || t.contains(dis) || t.contains(dis + 1)) {
          res.add(dis);
        }
      }
      dp.add(res);
    }
    return dp.get(dp.size() - 1).size() != 0;
  }
}
