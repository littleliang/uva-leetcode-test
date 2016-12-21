package leetcode389;

public class Solution {
  public char findTheDifference(String s, String t) {
    int[] stat = new int[26];
    for (int i = 0; i < s.length(); i++) {
      stat[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      if (stat[t.charAt(i) - 'a'] == 0) {
        return t.charAt(i);
      }
      stat[t.charAt(i) - 'a']--;
    }
    return ' ';
  }
}
