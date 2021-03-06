package leetcode58;

public class Solution {
  public int lengthOfLastWord(String s) {
    int len = s.length();
    int i = len - 1;
    int count = 0;

    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }

    for (; i >= 0; i--) {
      char ch = s.charAt(i);
      if (ch != ' ') {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
}
