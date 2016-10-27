package leetcode135;

public class Solution {
  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    int[] candiesl = new int[ratings.length];
    candiesl[0] = 1;
    int[] candiesr = new int[ratings.length];
    candiesr[ratings.length - 1] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candiesl[i] = candiesl[i - 1] + 1;
      } else {
        candiesl[i] = 1;
      }
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candiesr[i] = candiesr[i + 1] + 1;
      } else {
        candiesr[i] = 1;
      }
    }
    int result = 0;
    for (int i = 0; i < ratings.length; i++) {
      result += Math.max(candiesr[i], candiesl[i]);
    }
    return result;
  }
}
