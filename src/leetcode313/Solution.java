package leetcode313;

public class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] index = new int[primes.length];
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
      int temp = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        if (temp > primes[j] * res[index[j]]) {
          temp = primes[j] * res[index[j]];
        }
      }
      for (int j = 0; j < primes.length; j++) {
        if (temp == primes[j] * res[index[j]]) {
          index[j]++;
        }
      }
      res[i] = temp;
    }
    return res[n - 1];
  }
}
