package leetcode43;

public class Solution {
  public String multiply(String num1, String num2) {
    int num1Length = num1.length();
    int num2Length = num2.length();
    int d1, d2;
    int carry = 0;
    int temp;
    int[] caculate = new int[num1Length + num2Length];
    StringBuilder res = new StringBuilder();
    for (int i = num1.length() - 1; i >= 0; i--) {
      d1 = num1.charAt(i) - '0';
      for (int j = num2.length() - 1; j >= 0; j--) {
        d2 = num2.charAt(j) - '0';
        caculate[i + j + 1] += d1 * d2;
      }
    }
    for (int i = caculate.length - 1; i >= 0; i--) {
      temp = (caculate[i] + carry) % 10;
      carry = (caculate[i] + carry) / 10;
      caculate[i] = temp;
    }
    for (int num : caculate)
      res.append(num);
    while (res.length() > 1 && res.charAt(0) == '0') {
      res.deleteCharAt(0);
    }
    return res.toString();
  }
}
