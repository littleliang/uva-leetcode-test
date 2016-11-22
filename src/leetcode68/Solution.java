package leetcode68;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    char[] spaceStrs = new char[maxWidth];
    Arrays.fill(spaceStrs, ' ');
    List<String> just = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < words.length) {
      int wordsLen = 0, j = i, spaces = 0;
      while (wordsLen + spaces <= maxWidth && j < words.length) {
        if (j > i) {
          spaces++;
        }
        wordsLen += words[j++].length();
      }
      if (wordsLen + spaces > maxWidth) {
        wordsLen -= words[--j].length();
      }
      int nWords = j - i;
      int totalSpaces = maxWidth - wordsLen;
      sb.setLength(0);
      if (nWords == 1) { 
        sb.append(words[i++]);
        sb.append(spaceStrs, 0, totalSpaces);
      } else if (j == words.length) { 
        for (; i < j - 1; i++) {
          sb.append(words[i]);
          sb.append(' ');
        }
        sb.append(words[i++]);
        sb.append(spaceStrs, 0, maxWidth - sb.length());
      } else {
        int avgSpaces = totalSpaces / (nWords - 1);
        int extras = totalSpaces % (nWords - 1);
        for (; i < j - 1; i++) {
          sb.append(words[i]);
          sb.append(spaceStrs, 0, avgSpaces + ((extras-- > 0) ? 1 : 0));
        }
        sb.append(words[i++]);
      }
      just.add(sb.toString());
    }
    return just;
  }
}
