package leetcode129;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  private int res = 0;

  public int sumNumbers(TreeNode root) {
    if (root != null) {
      int sub = root.val;
      travel(root, sub);
    }
    return res;
  }

  private void travel(TreeNode node, int sub) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      res += sub;
      return;
    }
    if (node.left != null) {
      travel(node.left, sub * 10 + node.left.val);
    }
    if (node.right != null) {
      travel(node.right, sub * 10 + node.right.val);
    }
  }
}
