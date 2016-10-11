package leetcode139;

import java.util.Set;

public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    int length = s.length();
    boolean[] words = new boolean[length];
    for (int i = 1; i <= length; i++) {
      int j;
      for (j = 0; j < i; j++) {
        String substr = s.substring(j, i);
        if (wordDict.contains(substr) && (j == 0 || words[j - 1])) {
          words[i - 1] = true;
          break;
        }
      }
      if (j == i)
        words[i - 1] = false;
    }
    return words[length - 1];
  }
}
