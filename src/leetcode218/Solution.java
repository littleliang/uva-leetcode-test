package leetcode218;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<int[]>();
    if (buildings.length == 0)
      return result;
    PriorityQueue<int[]> queue =
        new PriorityQueue<int[]>(buildings.length, new Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
            return b[2] - a[2];
          }
        });
    for (int i = 0; i < buildings.length; i++) {
      int[] building = buildings[i];
      if (queue.isEmpty()) {
        result.add(new int[] {building[0], building[2]});
        queue.offer(building);
      } else {
        int[] top = queue.peek();
        if (building[0] > top[1]) {
          pop(queue, result, building[0]);
          i--;
        } else {
          if (building[2] > top[2]) {
            if (building[0] == top[0]) {
              result.get(result.size() - 1)[1] = building[2];
            } else {
              result.add(new int[] {building[0], building[2]});
            }
          }
          queue.offer(building);
        }
      }
    }
    pop(queue, result, (long) Integer.MAX_VALUE + 1);
    return result;
  }

  private void pop(PriorityQueue<int[]> queue, List<int[]> result, long boundary) {
    while (!queue.isEmpty() && queue.peek()[1] < boundary) {
      int[] top = queue.remove();
      while (!queue.isEmpty() && queue.peek()[1] <= top[1])
        queue.remove();
      if (queue.isEmpty()) {
        result.add(new int[] {top[1], 0});
      } else {
        int[] next = queue.peek();
        if (next[2] < top[2])
          result.add(new int[] {top[1], queue.peek()[2]});
      }
    }
  }
}
