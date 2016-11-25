package leetcode93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private List<String> res;
  private List<Integer> path;

  public List<String> restoreIpAddresses(String s) {
    res = new ArrayList<>();
    path = new ArrayList<>();
    int n = s.length();
    if (n > 12 || n < 4) {
      return res;
    }
    buildPath(0, 0, n, s, path);
    return res;
  }

  public void buildPath(int start, int level, int length, String s, List<Integer> path) {
    if (start == length) {
      return;
    }
    if (level == 3) {
      if (s.charAt(start) == '0' && start < length - 1) {
        return;
      }
      if (start < length - 3) {
        return;
      }
      int address = Integer.valueOf(s.substring(start, length));
      if (address <= 255) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : path) {
          stringBuilder.append(integer + ".");
        }
        stringBuilder.append(address);
        res.add(stringBuilder.toString());
      }
      return;
    }
    if (s.charAt(start) == '0') {
      path.add(0);
      buildPath(start + 1, level + 1, length, s, path);
      path.remove(path.size() - 1);
    } else {
      for (int end = start + 1; end <= Math.min(length, start + 3); end++) {
        int address = Integer.valueOf(s.substring(start, end));
        if (address <= 255) {
          path.add(address);
          buildPath(end, level + 1, length, s, path);
          path.remove(path.size() - 1);
        }
      }
    }
  }
}
