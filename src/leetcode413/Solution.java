package leetcode413;

public class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    int ans = 0;
    for (int i = 1; i <= A.length - 2; i++) {
      if (A[i] - A[i - 1] == A[i + 1] - A[i]) {
        int numOfConti = 3;
        while (i < A.length - 2 && A[i + 2] == 2 * A[i + 1] - A[i]) {
          numOfConti++;
          i++;
        }
        ans += (numOfConti - 1) * (numOfConti - 2) / 2;
      }
    }
    return ans;
  }
}

