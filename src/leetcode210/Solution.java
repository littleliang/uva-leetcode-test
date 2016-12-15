package leetcode210;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] map = new int[numCourses];
    int[] res = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      map[prerequisites[i][0]]++;
    }
    Queue<Integer> que = new LinkedList<Integer>();
    int index = 0;
    for (int i = 0; i < map.length; i++) {
      if (map[i] == 0){
        que.add(i);
        res[index++] = i;
      }
    }
    int count = que.size();
    while (!que.isEmpty()) {
      int k = que.remove();
      for (int i = 0; i < prerequisites.length; i++) {
        if (k == prerequisites[i][1]) {
          int l = prerequisites[i][0];
          map[l]--;
          if (map[l] == 0) {
            que.add(l);
            res[index++] = l;
            ++count;
          }
        }
      }
    }
    if (count == numCourses){
      return res;
    }else{
      return new int[0];
    }
  }
}
