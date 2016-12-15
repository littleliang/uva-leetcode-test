package leetcode204;

public class Solution {
  public int countPrimes(int n) {
    int[] isPrimes = new int[n + 1];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrimes[i] == 0) {
        count++;
      }
      int j = 2;
      while (j * i < n) {
        isPrimes[j * i] = 1;
        j++;
      }
    }
    return count;
  }
}
