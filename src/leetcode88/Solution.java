package leetcode88;

public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int count = m + n - 1;
    n--;
    m--;
    while (n >= 0) {
      if (m == -1) {
        nums1[count] = nums2[n];
        count--;
        n--;
      } else {
        if (nums1[m] >= nums2[n]) {
          nums1[count] = nums1[m];
          count--;
          m--;
        } else {
          nums1[count] = nums2[n];
          count--;
          n--;
        }
      }
    }
  }
}
