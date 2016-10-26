package leetcode124;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  private int res = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    pathSum(root);
    return res;
  }

  public int pathSum(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = Math.max(0, pathSum(node.left));
    int right = Math.max(0, pathSum(node.right));
    res = Math.max(res, left + right + node.val);
    return Math.max(left, right) + node.val;
  }
}
