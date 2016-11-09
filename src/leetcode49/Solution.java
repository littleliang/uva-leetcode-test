package leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> list = new ArrayList<List<String>>();
    if (strs == null || strs.length == 0) {
      return list;
    }
    Arrays.sort(strs);
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      char[] tmp = str.toCharArray();
      Arrays.sort(tmp);
      String sortStr = String.valueOf(tmp);
      if (!map.keySet().contains(sortStr)) {
        map.put(sortStr, new ArrayList<String>());
      }
      map.get(sortStr).add(str);
    }
    for (String str : map.keySet()) {
      list.add(map.get(str));
    }
    return list;
  }
}
