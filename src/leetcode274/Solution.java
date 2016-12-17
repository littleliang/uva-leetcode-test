package leetcode274;

import java.util.Arrays;

public class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int h = 0;
    for (int i = citations.length - 1; i >= 0; i--) {
      h++;
      if (citations[i] < h) {
        return h - 1;
      }
    }
    return h;
  }
}
