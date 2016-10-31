package leetcode132;

import java.util.Arrays;

public class Solution {
  int[] cut;

  public int minCut(String s) {
    int len = s.length();
    char[] tmp = s.toCharArray();
    cut = new int[s.length()];
    Arrays.fill(cut, Integer.MAX_VALUE);
    for (int i = 0; i < len; i++) {
      re(tmp, i, i);
      re(tmp, i - 1, i);
    }
    return cut[len - 1];
  }

  public void re(char[] s, int start, int end) {
    if (start < 0 || end >= s.length)
      return;
    if (s[start] == s[end]) {
      re(s, start - 1, end + 1);
      int tmp = start == 0 ? 0 : cut[start - 1] + 1;
      cut[end] = Math.min(tmp, cut[end]);
    }
  }
}
