package leetcode104;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  private int max = 0;

  public int maxDepth(TreeNode root) {
    DFS(root, 0);
    return max;
  }

  public void DFS(TreeNode root, int layer) {
    if (root == null) {
      if (layer > max) {
        max = layer;
      }
      return;
    }
    DFS(root.left, layer + 1);
    DFS(root.right, layer + 1);
    return;
  }
}
