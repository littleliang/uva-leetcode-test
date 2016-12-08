package leetcode166;

import java.util.HashMap;

public class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    StringBuffer res = new StringBuffer();
    StringBuffer number = new StringBuffer();
    long num = (long) numerator;
    long denom = (long) denominator;
    HashMap<Long, Integer> maps = new HashMap<>();
    if (num * denom < 0) {
      res.append("-");
    }
    num = Math.abs(num);
    denom = Math.abs(denom);
    res.append(num / denom);
    num = num % denom * 10;
    int index = 0;
    int beginIndex = -1;
    while (num != 0) {
      if (maps.containsKey(num)) {
        beginIndex = maps.get(num);
        break;
      }
      maps.put(num, index++);
      number.append(num / denom);
      num = num % denom * 10;
    }
    for (int i = 0; i < index; i++) {
      if (i == 0)
        res.append('.');
      if (i == beginIndex) {
        res.append('(');
      }
      res.append(number.charAt(i));
    }
    if (beginIndex != -1)
      res.append(')');
    return res.toString();
  }
}
