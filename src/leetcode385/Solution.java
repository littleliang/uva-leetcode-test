package leetcode385;

import java.util.ArrayList;
import java.util.List;

class NestedInteger {
  public NestedInteger() {}

  public NestedInteger(int value) {}

  public boolean isInteger() {
    return true;
  }

  public Integer getInteger() {
    return 0;
  }

  public void setInteger(int value) {}

  public void add(NestedInteger ni) {}

  public List<NestedInteger> getList() {
    return new ArrayList<>();
  }
}


public class Solution {
  public NestedInteger deserialize(String s) {
    if (s.contains("[")) {
      NestedInteger ans = new NestedInteger();
      if (s.length() > 2) {
        int begin = 1;
        char[] cs = s.toCharArray();
        int count = 0;
        for (int i = 1; i < s.length() - 1; i++) {
          if (cs[i] == ',' && count == 0) {
            ans.add(deserialize(s.substring(begin, i)));
            begin = i + 1;
          }
          if (cs[i] == '[' || cs[i] == ']') {
            count += (92 - cs[i]);
          }
        }
        ans.add(deserialize(s.substring(begin, s.length() - 1)));
      }
      return ans;
    }
    return new NestedInteger(Integer.valueOf(s));
  }
}
