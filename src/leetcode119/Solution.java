package leetcode119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> getRow(int rowIndex) {
    if (rowIndex < 0) {
      return null;
    }
    List<Integer> res = new ArrayList<>();
    long sum = 1;
    res.add(1);
    for(int i = 1; i <= rowIndex; i++) {
      int temp = (int) (sum * (rowIndex + 1 - i) / i);
      res.add(temp);
      sum = temp;
    }
    return res;
  }
}
