package leetcode128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  int[] id;
  int[] sz;
  Map<Integer, Integer> map;

  public int longestConsecutive(int[] nums) {
    id = new int[nums.length];
    sz = new int[nums.length];
    map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      insert(nums[i], i);
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res = Math.max(res, sz[i]);
    }
    return res;
  }

  private void insert(int num, int index) {
    if (!map.containsKey(num)) {
      map.put(num, index);
      id[index] = index;
      sz[index] = 1;
      if (map.containsKey(num - 1)) {
        unite(num - 1, num);
      }
      if (map.containsKey(num + 1)) {
        unite(num + 1, num);
      }
    }
  }

  private void unite(int num1, int num2) {
    int p = findSet(map.get(num1));
    int q = findSet(map.get(num2));
    if (p != q) {
      if (sz[p] > sz[q]) {
        id[q] = p;
        sz[p] += sz[q];
      } else {
        id[p] = q;
        sz[q] += sz[p];
      }
    }
  }

  private int findSet(int p) {
    if (id[p] != p) {
      id[p] = findSet(id[p]);
    }
    return id[p];
  }
}
