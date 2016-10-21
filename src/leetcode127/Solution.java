package leetcode127;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    int pathLength = 2;
    Set<String> start = new HashSet<>();
    Set<String> end = new HashSet<>();
    start.add(beginWord);
    end.add(endWord);
    wordList.remove(beginWord);
    wordList.remove(endWord);
    while (!start.isEmpty()) {
      if (start.size() > end.size()) {
        Set<String> temp = start;
        start = end;
        end = temp;
      }
      Set<String> next = new HashSet<>();
      for (String cur : start) {
        char[] strArray = cur.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
          char old = strArray[i];
          for (char c = 'a'; c <= 'z'; c++) {
            strArray[i] = c;
            String str = String.valueOf(strArray);
            if (end.contains(str)) {
              return pathLength;
            }
            if (wordList.contains(str)) {
              next.add(str);
              wordList.remove(str);
            }
          }
          strArray[i] = old;
        }
      }
      start = next;
      pathLength++;
    }
    return 0;
  }
}
