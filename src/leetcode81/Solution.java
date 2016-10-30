package leetcode81;

public class Solution {
  public boolean search(int[] A, int target) {
    int start = 0, end = A.length - 1;
    while (start <= end) {
      if (start > end)
        return false;
      int mid = (start + end) >> 1;
      if (A[mid] == target)
        return true;
      if (A[mid] > A[start]) {
        if (A[start] <= target && target < A[mid])
          end = mid - 1;
        else
          start = mid + 1;
      } else if (A[mid] < A[start]) {
        if (A[mid] < target && target <= A[end])
          start = mid + 1;
        else
          end = mid - 1;
      } else if (A[mid] == A[start]) {
        start++;
      }
    }
    return false;
  }
}
