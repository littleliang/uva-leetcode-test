package leetcode57;

import java.util.ArrayList;
import java.util.List;

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
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> ret = new ArrayList<>();
    if (intervals.isEmpty()) {
      ret.add(newInterval);
      return ret;
    }

    int i = 0;
    while (i < intervals.size()) {
      if (newInterval.end < intervals.get(i).start) {
        ret.add(newInterval);
        while (i < intervals.size()) {
          ret.add(intervals.get(i));
          i++;
        }
        return ret;
      } else if (newInterval.start > intervals.get(i).end)
        ret.add(intervals.get(i));
      else {
        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      }
      i++;
    }
    ret.add(newInterval);
    return ret;
  }
}
