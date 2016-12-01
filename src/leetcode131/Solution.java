package leetcode131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
  public boolean[][] isPalindrome(String s) {
    boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++)
      isPalindrome[i][i] = true;
    for (int i = 0; i < s.length() - 1; i++)
      isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
    for (int length = 2; length < s.length(); length++) {
      for (int start = 0; start + length < s.length(); start++) {
        isPalindrome[start][start + length] = isPalindrome[start + 1][start + length - 1]
            && s.charAt(start) == s.charAt(start + length);
      }
    }
    return isPalindrome;
  }

  public List<List<String>> partition(String s) {
    boolean[][] isPalindrome = isPalindrome(s);
    HashMap<Integer, List<List<String>>> hm = new HashMap<Integer, List<List<String>>>();
    for (int i = 0; i < s.length(); i++) {
      List<List<String>> ls = new ArrayList<List<String>>();
      if (isPalindrome[0][i]) {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(s.substring(0, i + 1));
        ls.add(temp);
      }
      for (int j = 1; j <= i; j++) {
        if (isPalindrome[j][i]) {
          List<List<String>> l = hm.get(j - 1);
          List<List<String>> al = new ArrayList<List<String>>();
          for (List<String> temp : l) {
            ArrayList<String> clone = new ArrayList<String>(temp);
            clone.add(s.substring(j, i + 1));
            al.add(clone);
          }
          ls.addAll(al);
        }
      }
      hm.put(i, ls);
    }
    return hm.get(s.length() - 1);
  }
}
