package leetcode153;

public class Solution {
  public int findMin(int[] num) {
    if (num == null || num.length < 1)
      return 0;
    int low = 0, high = num.length - 1;
    while (low < high && num[low] > num[high]) {
      int mid = low + (high - low) / 2;
      if (num[mid] > num[low]) {
        low = mid + 1;
      } else if (num[mid] == num[low]) {
        return num[high];
      } else {
        high = mid;
      }
    }
    return num[low];
  }
}
