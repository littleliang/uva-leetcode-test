package leetcode29;

public class Solution {
  public int divide(int dividend, int divisor) {
    int sign = 1;
    if (dividend < 0)
      sign = -sign;
    if (divisor < 0)
      sign = -sign;
    long temp = Math.abs((long) dividend);
    long temp2 = Math.abs((long) divisor);
    long c = 1;
    while (temp > temp2) {
      temp2 = temp2 << 1;
      c = c << 1;
    }
    long res = 0;
    while (temp >= Math.abs((long) divisor)) {
      while (temp >= temp2) {
        temp -= temp2;
        res += c;
      }
      temp2 = temp2 >> 1;
      c = c >> 1;
    }
    res = res * sign;
    if(res > Integer.MAX_VALUE){
      return Integer.MAX_VALUE;
    }
    return (int) res;
  }
}
