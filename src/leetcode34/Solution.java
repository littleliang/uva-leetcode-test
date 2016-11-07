package leetcode34;

public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] res = {-1, -1};
    if (target < nums[0] || target > nums[nums.length - 1]) {
      return res;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    res[0] = start;
    start = 0;
    end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    res[1] = end;
    if (res[1] >= res[0]) {
      return res;
    } else {
      res[0] = -1;
      res[1] = -1;
      return res;
    }
  }
}
