package leetcode7;

public class Solution {
  public int reverse(int x) {
    int flag = x >= 0 ? 1 : -1;
    Long input = Math.abs((long) x);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(input));
    long res = flag * Long.parseLong(stringBuilder.reverse().toString());
    res = res < Integer.MIN_VALUE ? 0 : res;
    res = res > Integer.MAX_VALUE ? 0 : res;
    return (int) res;
  }
}
