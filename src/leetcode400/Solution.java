package leetcode400;

public class Solution {
  public int findNthDigit(int n) {
    if (n < 1) {
      return -1;
    }
    long dump = 9;
    int count = 1;
    long nlong = n;
    while (n > dump * count) {
      nlong = nlong - dump * count;
      dump = dump * 10;
      count++;
    }
    n = (int) nlong;
    int index = (n - 1) / count;
    int bit = (n - 1) % count;
    int res = ((int) Math.pow(10, count - 1) + index) / (int) Math.pow(10, count - 1 - bit) % 10;
    return res;
  }
}
