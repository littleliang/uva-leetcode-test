package leetcode260;

public class Solution {
  public int[] singleNumber(int[] nums) {
    int[] res = new int[2];
    int bitSum = 0;
    for (int i : nums) {
      bitSum ^= i;
    }
    int mask = 1;
    while ((bitSum | mask) != bitSum) {
      mask = mask << 1;
    }
    for (int i : nums) {
      if ((i | mask) != i) {
        res[0] ^= i;
      } else {
        res[1] ^= i;
      }
    }
    return res;
  }
}
