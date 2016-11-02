package leetcode6;

public class Solution {
  public String convert(String s, int nRows) {
    StringBuilder[] stringBuilder = new StringBuilder[nRows];
    for (int i = 0; i < nRows; i++)
      stringBuilder[i] = new StringBuilder();
    boolean reverse = true;
    if (nRows == 1)
      return s;
    if (s.length() == 1)
      return s;
    for (int i = 0; i < s.length(); ++i) {
      if (i % (nRows - 1) == 0)
        reverse = !reverse;
      if (!reverse) {
        stringBuilder[i % (nRows - 1)].append(s.charAt(i));
      } else {
        stringBuilder[nRows - 1 - (i % (nRows - 1))].append(s.charAt(i));
      }
    }
    for (int i = 1; i < nRows; i++) {
      stringBuilder[0].append(stringBuilder[i]);
    }
    return stringBuilder[0].toString();
  }
}
