package leetcode242;

public class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] stat = new int[26];
    for (int i = 0; i < s.length(); i++) {
      stat[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      if (stat[t.charAt(i) - 'a'] == 0) {
        return false;
      }
      stat[t.charAt(i) - 'a']--;
    }
    return true;
  }
}
