package leetcode436;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}


public class Solution {
  public int[] findRightInterval(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0];
    }

    TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer e0, Integer e1) {
        return Integer.compare(e0, e1);
      }
    });

    int n = intervals.length;
    for (int i = 0; i < n; i++) {
      map.put(intervals[i].start, i);
    }

    int[] ret = new int[n];
    for (int i = 0; i < n; i++) {
      Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
      ret[i] = entry != null ? entry.getValue() : -1;
    }
    return ret;
  }
}
