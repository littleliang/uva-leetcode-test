package leetcode80;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int index = 0;
    boolean flag = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[index]) {
        flag = false;
        index++;
        nums[index] = nums[i];
      } else if (nums[i] == nums[index] && flag == false) {
        flag = true;
        index++;
        nums[index] = nums[i];
      }
    }
    return index + 1;
  }
}
