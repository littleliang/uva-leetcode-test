package leetcode76;


public class Solution {
  public String minWindow(String s, String t) {
    int[] tmap = freq(t);
    int[] wmap = freq("");
    String ret = "";
    int min = Integer.MAX_VALUE;
    for (int left = 0, right = 0; right < s.length(); right++) {
      wmap[s.charAt(right)]++;
      if (!isCover(wmap, tmap))
        continue;
      while (left <= right) {
        char c = s.charAt(left);
        if (wmap[c] == tmap[c])
          break;

        wmap[c]--;
        left++;
      }

      String w = s.substring(left, right + 1);
      if (w.length() < min) {
        min = w.length();
        ret = w;
      }
    }

    return ret;
  }

  boolean isCover(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] < b[i])
        return false;
    }
    return true;
  }

  int[] freq(String s) {
    int[] ret = new int[256];
    for (char c : s.toCharArray()) {
      ret[c]++;
    }
    return ret;
  }
}

