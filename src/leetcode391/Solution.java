package leetcode391;

import java.util.HashMap;

public class Solution {
  class Point {
    int x;
    int y;
    int index;

    Point(int x, int y, int index) {
      this.x = x;
      this.y = y;
      this.index = index;
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Point) {
        Point b = (Point) o;
        return this.x == b.x && this.y == b.y;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return (new Integer(x).hashCode() + new Integer(y).hashCode());
    }
  }

  public boolean isRectangleCover(int[][] rectangles) {
    if (rectangles.length <= 1) {
      return true;
    }

    int sum = 0;
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    HashMap<Point, Integer> hm = new HashMap<>();
    for (int[] rect : rectangles) {
      Point p1 = new Point(rect[0], rect[1], 1);
      Point p2 = new Point(rect[2], rect[3], 2);
      Point p3 = new Point(rect[0], rect[3], 3);
      Point p4 = new Point(rect[2], rect[1], 4);
      sum += (rect[2] - rect[0]) * (rect[3] - rect[1]);

      minX = Math.min(minX, rect[0]);
      minY = Math.min(minY, rect[1]);

      maxX = Math.max(maxX, rect[2]);
      maxY = Math.max(maxY, rect[3]);

      Point[] points = {p1, p2, p3, p4};
      for (Point p : points) {
        if (hm.containsKey(p) && hm.get(p) != p.index) {
          hm.remove(p);
        } else {
          hm.put(p, p.index);
        }
      }
    }
    return (hm.size() == 4) && (sum == (maxX - minX) * (maxY - minY));
  }
}
