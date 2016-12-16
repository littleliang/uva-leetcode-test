package leetcode217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> unique = new HashSet<Integer>();
    for (int x : nums) {
      if (unique.contains(x))
        return true;
      else
        unique.add(x);
    }
    return false;
  }
}
