package leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    Map<String, Integer> baseMap = new HashMap<>();
    for (String word : words) {
      Integer n = baseMap.get(word);
      if (n == null)
        n = 0;
      baseMap.put(word, n + 1);
    }
    int length = words[0].length();
    for (int i = 0; i < length; i++) {
      int left = i;
      int right = left;
      int counter = words.length;
      Map<String, Integer> map = new HashMap<>(baseMap);
      while (right + length <= s.length()) {
        String sub = s.substring(right, right + length);
        right += length;
        Integer cnt = map.get(sub);
        if (cnt != null) {
          if (cnt-- > 0)
            counter--;
          map.put(sub, cnt);
        }
        if (counter == 0) {
          res.add(left);
        }
        if (right - left == words.length * length) {
          sub = s.substring(left, left + length);
          left += length;
          cnt = map.get(sub);
          if (cnt != null) {
            if (cnt++ >= 0 && cnt <= baseMap.get(sub))
              counter++;
            map.put(sub, cnt);
          }
        }
      }
    }
    return res;
  }
}
