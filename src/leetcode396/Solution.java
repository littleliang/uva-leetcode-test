package leetcode396;

public class Solution {
  public int maxRotateFunction(int[] A) {
    int n = A.length;
    int arraySum = 0;
    int fSum = 0;
    for (int i = 0; i < n; i++) {
      arraySum += A[i];
      fSum += A[i] * i;
    }
    int max = fSum;
    for (int i = 1; i < n; i++) {
      fSum = fSum + arraySum - A[n - i] * n;
      max = Math.max(max, fSum);
    }
    return max;
  }
}
