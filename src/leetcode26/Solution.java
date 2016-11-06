package leetcode26;

public class Solution {
  public int removeDuplicates(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    if (A.length == 1) {
      return 1;
    }
    int index = 0;
    for (int i = 1; i < A.length; ++i) {
      if (A[i] != A[index]) {
        ++index;
        A[index] = A[i];
      }
    }
    return index + 1;
  }
}
