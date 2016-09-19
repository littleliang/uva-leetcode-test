package leetcode56;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
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
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new LinkedList<>();
		if (intervals.size() <= 0)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start)
					return -1;
				else if (o1.start > o2.start)
					return 1;
				else
					return 0;
			}
		});
		Interval top = intervals.get(0);
		res.add(new Interval(top.start, top.end));

		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			top = res.get(res.size() - 1);

			if (top.end >= current.start) {
				top.end = Math.max(current.end, top.end);
			} else
				res.add(new Interval(current.start, current.end));
		}

		return res;
	}
}
