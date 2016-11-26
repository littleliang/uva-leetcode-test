package leetcode113;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  private List<List<Integer>> res;
  private List<Integer> path;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    res = new ArrayList<>();
    path = new ArrayList<>();
    pathSum(root, sum, 0);
    return res;
  }

  private void pathSum(TreeNode node, int sum, int temp) {
    if (node == null) {
      return;
    }
    path.add(node.val);
    temp += node.val;
    if (node.left == null && node.right == null) {
      if (temp == sum) {
        res.add(new ArrayList<>(path));
      }
      path.remove(path.size() - 1);
      return;
    }
    if (node.left != null) {
      pathSum(node.left, sum, temp);
    }
    if (node.right != null) {
      pathSum(node.right, sum, temp);
    }
    path.remove(path.size() - 1);
  }
}
