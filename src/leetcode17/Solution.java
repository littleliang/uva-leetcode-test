package leetcode17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> letterCombinations(String digits) {
    String[] table =
        new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<String>();
    letterCombinations(list, digits, "", 0, table);
    return list;
  }

  private void letterCombinations(List<String> list, String digits, String curr, int index,
      String[] table) {
    if (index == digits.length()) {
      if (curr.length() != 0)
        list.add(curr);
      return;
    }
    String temp = table[digits.charAt(index) - '0'];
    for (int i = 0; i < temp.length(); i++) {
      String next = curr + temp.charAt(i);
      letterCombinations(list, digits, next, index + 1, table);
    }
  }
}
