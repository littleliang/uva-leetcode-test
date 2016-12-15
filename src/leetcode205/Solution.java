package leetcode205;

import java.util.HashMap;

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character key = s.charAt(i);
      Character value = t.charAt(i);
      if (map.containsKey(key)) {
        if (!value.equals(map.get(key))) {
          return false;
        }
      }
      map.put(key, value);
    }
    map.clear();
    for (int i = 0; i < s.length(); i++) {
      Character key = t.charAt(i);
      Character value = s.charAt(i);
      if (map.containsKey(key)) {
        if (!value.equals(map.get(key))) {
          return false;
        }
      }
      map.put(key, value);
    }
    return true;
  }
}
