package leetcode373;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> res = new ArrayList<>();
    int m = nums1.length;
    int n = nums2.length;
    int[] index = new int[m];
    k = Math.min(k, m * n);
    while (k > 0) {
      int temp = 0;
      long min = Long.MAX_VALUE;
      for (int i = 0; i < m; i++) {
        if (index[i] < n && min > nums1[i] + nums2[index[i]]) {
          min = nums1[i] + nums2[index[i]];
          temp = i;
        }
      }
      res.add(new int[] {nums1[temp], nums2[index[temp]]});
      index[temp]++;
      k--;
    }
    return res;
  }
}
