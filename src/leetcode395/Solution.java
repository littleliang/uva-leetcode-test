package leetcode395;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {

	private int lastlen(Map<Character, Deque<Integer>> lists, int k) {

		int start = -1;
		Set<Character> set = new HashSet<>();
		for (Character c : lists.keySet()) {
			Deque<Integer> list = lists.get(c);
			if (list != null && list.size() < k) {
				start = Math.max(start, list.getLast());
			} else {
				set.add(c);
				while (list.size() > k) {
					list.remove();
				}
			}
		}

		boolean exists = true;
		while (exists) {
			exists = false;
			Iterator<Character> it = set.iterator();
			while (it.hasNext()) {
				Deque<Integer> list = lists.get(it.next());
				if (list.peekFirst() < start) {
					start = Math.max(start, list.peekLast());
					exists = true;
					it.remove();
				}
			}
		}

		return start;
	}

	public int longestSubstring(String s, int k) {

		int res = 0;
		Integer start = null;
		Map<Character, Deque<Integer>> indices = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			Deque<Integer> q = indices.get(c);
			if (q == null)
				indices.put(c, q = new ArrayDeque<Integer>());
			q.offer(i);
			if (start != null && q.size() >= k && q.getFirst() > start)
				;
			else {
				start = lastlen(indices, k);
			}
			res = Math.max(i - start, res);
		}

		return res;

	}
}
