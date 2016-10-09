package leetcode415;

public class Solution {
  public String addStrings(String num1, String num2) {
    String longer = num1;
    String shorter = num2;
    if (longer.length() < shorter.length()) {
      longer = num2;
      shorter = num1;
    }
    int n = longer.length();
    int m = shorter.length();
    char l[] = longer.toCharArray();
    char s[] = shorter.toCharArray();
    int remainder = 0;
    char base = '0';
    int tmp;
    StringBuilder res = new StringBuilder();
    while (m-- > 0) {
      n--;
      tmp = l[n] + s[m] - 2 * base + remainder;
      remainder = tmp / 10;
      res.append(tmp % 10);
    }
    while (n-- > 0) {
      tmp = l[n] - base + remainder;
      remainder = tmp / 10;
      res.append(tmp % 10);
    }
    if (remainder != 0)
      res.append(remainder);
    return res.reverse().toString();
  }
}
