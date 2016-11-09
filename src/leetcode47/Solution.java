package leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    permute(nums, temp, visited);
    return res;
  }

  public void permute(int[] nums, List<Integer> temp, boolean[] visited) {
    if (temp.size() == nums.length) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
        continue;
      }
      visited[i] = true;
      temp.add(nums[i]);
      permute(nums, temp, visited);
      visited[i] = false;
      temp.remove(temp.size() - 1);
    }
  }
}
