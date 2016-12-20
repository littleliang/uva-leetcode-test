package leetcode332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, List<String>> itineraryMap = new HashMap<>();
    for (String[] ticket : tickets) {
      List<String> dests = itineraryMap.get(ticket[0]);
      if (dests == null) {
        dests = new ArrayList<>();
        dests.add(ticket[1]);
        itineraryMap.put(ticket[0], dests);
      } else {
        dests.add(ticket[1]);
      }
    }
    for (List<String> dests : itineraryMap.values()) {
      Collections.sort(dests);
    }
    List<String> res = new ArrayList<>();
    res.add("JFK");
    dfs(res, new ArrayList<String>(), itineraryMap, "JFK", tickets.length);
    return res;
  }

  private void dfs(List<String> res, List<String> cur, Map<String, List<String>> itineraryMap,
      String src, int len) {
    if (res.size() > 1) {
      return;
    }
    if (cur.size() == len) {
      res.addAll(cur);
      return;
    }
    List<String> dests = itineraryMap.get(src);
    if (dests != null && dests.size() > 0) {
      for (int i = 0; i < dests.size(); i++) {
        String des = dests.remove(i);
        cur.add(des);
        dfs(res, cur, itineraryMap, des, len);
        dests.add(i, des);
        cur.remove(cur.size() - 1);
      }
    }
  }
}
