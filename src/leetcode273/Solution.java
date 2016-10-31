package leetcode273;

public class Solution {
  private static final String[] inTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six",
      "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
      "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private static final String[] tens =
      {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private static final int TEN = 10, HUNDRED = 100, T = 1000, M = 1000000, B = 1000000000;
  private static final String HH = " Hundred ", TT = " Thousand ", MM = " Million ",
      BB = " Billion ";

  public String numberToWords(int num) {
    if (num == 0)
      return "Zero";
    return numberToWordsHelper(num);
  }

  public static String numberToWordsHelper(int num) {
    String res = "";
    if (num < T)
      return lessThan1000(num);
    else if (num < M) {
      res = lessThan1000(num / T) + TT + numberToWordsHelper(num % T);
    } else if (num < B) {
      res = lessThan1000(num / M) + MM + numberToWordsHelper(num % M);
    } else
      res = lessThan1000(num / B) + BB + numberToWordsHelper(num % B);
    return res.trim();
  }

  private static String lessThan100(int num) {
    if (num < 20)
      return inTwenty[num];
    int ten = num / TEN, one = num % TEN;
    return (tens[ten] + " " + inTwenty[one]).trim();
  }

  private static String lessThan1000(int num) {
    if (num < HUNDRED)
      return lessThan100(num);
    int hun = num / HUNDRED, rem = num % HUNDRED;
    return (inTwenty[hun] + HH + lessThan100(rem)).trim();
  }
}
