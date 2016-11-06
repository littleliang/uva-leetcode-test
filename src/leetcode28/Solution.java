package leetcode28;

public class Solution {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() == 0) {
      return -1;
    }
    int result = -1;
    for (int index = 0; index <= haystack.length() - needle.length(); index++) {
      for (int i = 0; i < needle.length(); i++) {
        if (haystack.charAt(index + i) != needle.charAt(i)) {
          break;
        }
        if (i == needle.length() - 1) {
          return index;
        }
      }
    }
    return result;
  }
}
