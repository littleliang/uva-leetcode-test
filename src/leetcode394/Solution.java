package leetcode394;

import java.util.Stack;

public class Solution {
  public String decodeString(String s) {
    int n = s.length();
    char[] ss = s.toCharArray();
    Stack<Integer> counts = new Stack<Integer>();
    Stack<String> strings = new Stack<String>();
    StringBuilder result = new StringBuilder();
    int count = 0;
    String currentString = "";
    for (int i = 0; i < n; i++) {
      if (ss[i] >= '0' && ss[i] <= '9') {
        count = count * 10;
        count = count + ss[i] - '0';
      } else if (ss[i] == '[') {
        counts.push(count);
        count = 0;
        strings.push(currentString);
        currentString = "";
      } else if (ss[i] >= 'a' && ss[i] <= 'z') {
        if (!counts.isEmpty())
          currentString += ss[i];
        else
          result.append(ss[i]);
      } else if (ss[i] == ']') {
        int times = counts.pop();
        if (counts.isEmpty()) {
          for (int j = 0; j < times; j++)
            result.append(currentString);
          currentString = strings.pop();
        } else {
          String tmp = "";
          for (int j = 0; j < times; j++)
            tmp += currentString;
          currentString = strings.pop() + tmp;
        }
      }
    }
    return result.toString();
  }
}
