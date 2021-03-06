package leetcode111;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  private int min = Integer.MAX_VALUE;

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    travelNode(root, 0);
    return min;
  }

  public void travelNode(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (depth + 1 < min) {
        min = depth + 1;
      }
      return;
    }
    travelNode(root.left, depth + 1);
    travelNode(root.right, depth + 1);
    return;
  }
}
