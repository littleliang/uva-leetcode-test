package leetcode438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s == null || p == null || s.length() == 0 || p.length() == 0) {
      return res;
    }
    int len1 = s.length(), len2 = p.length();
    if (len2 > len1)
      return res;
    int[] anagram = new int[128];

    for (int i = 0; i < len2; i++) {
      anagram[s.charAt(i)]++;
      anagram[p.charAt(i)]--;
    }
    int diff = 0;
    for (int i : anagram) {
      if (i != 0)
        diff++;
    }
    for (int i = len2; i < len1; i++) {
      if (diff == 0)
        res.add(i - len2);
      char c1 = s.charAt(i);
      char c2 = s.charAt(i - len2);
      if (c1 == c2)
        continue;

      anagram[c1]++;
      anagram[c2]--;
      if (anagram[c1] == 1)
        diff++;
      else if (anagram[c1] == 0)
        diff--;

      if (anagram[c2] == -1)
        diff++;
      else if (anagram[c2] == 0)
        diff--;
    }
    if (diff == 0) {
      res.add(len1 - len2);
    }
    return res;
  }
}
