package leetcode41;

public class Solution {

  public int firstMissingPositive(int[] A) {
    for (int i = 0; i < A.length; i++) {
      while (A[i] != i + 1) {
        if (A[i] <= 0 || A[i] >= A.length || A[i] == A[A[i] - 1])
          break;
        int temp = A[i];
        A[i] = A[A[i] - 1];
        A[temp - 1] = temp;
      }

    }
    for (int i = 0; i < A.length; i++) {
      if (A[i] != i + 1)
        return i + 1;
    }
    return A.length + 1;
  }
}
