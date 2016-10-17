package leetcode5;

public class Solution {
  public String longestPalindrome(String s) {
    int nLen = s.length();
    if (nLen == 0)
      return "";
    String lonStr = s.substring(0, 1);
    for (int i = 0; i < nLen - 1; i++) {
      String p1 = ExpandAroundCenter(s, i, i);
      if (p1.length() > lonStr.length())
        lonStr = p1;
      String p2 = ExpandAroundCenter(s, i, i + 1);
      if (p2.length() > lonStr.length())
        lonStr = p2;
    }
    return lonStr;
  }

  public static String ExpandAroundCenter(String s, int n, int m) {
    int l = n, r = m;
    int nLen = s.length();
    while (l >= 0 && r <= nLen - 1 && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return s.substring(l + 1, r);
  }
}
