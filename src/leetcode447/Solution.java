package leetcode447;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int numberOfBoomerangs(int[][] points) {
    int n = points.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int j = 0; j < n; j++) {
        if (i != j) {
          int key = getDis(points[i], points[j]);
          map.putIfAbsent(key, 0);
          int val = map.get(key);
          map.put(key, val + 1);
        }
      }
      for (Integer k : map.keySet()) {
        int tmp = map.get(k);
        if (tmp > 1) {
          res += (tmp * (tmp - 1));
        }
      }
    }
    return res;
  }

  public int getDis(int[] a, int[] b) {
    return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
  }
}
