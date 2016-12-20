package leetcode349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0)
      return new int[0];
    Set<Integer> result = new HashSet<Integer>();
    Set<Integer> set1 = new HashSet<Integer>();
    for (int i = 0; i < nums1.length; i++) {
      set1.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (set1.contains(nums2[i]))
        result.add(nums2[i]);
    }
    int[] res = new int[result.size()];
    int i = 0;
    Iterator<Integer> iter = result.iterator();
    while (iter.hasNext()) {
      res[i++] = (int) iter.next();
    }
    return res;
  }
}
