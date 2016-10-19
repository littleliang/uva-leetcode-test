package leetcode71;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public String simplifyPath(String path) {
    List<String> res = new ArrayList<>();
    String[] attr = path.split("/");
    for (String string : attr) {
      if (string.equals("..")) {
        if (res.size() > 0) {
          res.remove(res.size() - 1);
        }
      } else if (string.equals("") || string.equals(".")) {
        continue;
      } else {
        res.add(string);
      }
    }
    if (res.isEmpty()) {
      return "/";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (String string : res) {
      stringBuilder.append("/" + string);
    }
    return stringBuilder.toString();
  }
}
