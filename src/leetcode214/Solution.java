package leetcode214;

public class Solution {
  public String shortestPalindrome(String s) {
    char[] str = s.toCharArray();
    int n = str.length;
    if (n <= 1)
      return s;
    int[] next = new int[n >> 1];
    next[0] = 0;
    int j = 0;
    for (int i = 1; i < next.length;) {
      if (str[j] == str[i]) {
        next[i++] = j + 1;
      } else {
        if (j == 0) {
          next[i++] = 0;
          continue;
        }
        j = next[j];
      }
    }
    int index = n - 1;
    while (true) {
      int from = 0, to = index;
      while (from < to && str[from] == str[to]) {
        from++;
        to--;
      }
      if (from >= to)
        break;
      else {
        if (from == 0)
          index--;
        else
          index = to + next[from - 1];
      }
    }
    return new StringBuilder(s.substring(index + 1)).reverse().toString() + s;
  }
}
