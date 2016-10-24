package leetcode421;

public class Solution {
  class TreeNode {
    TreeNode left, right;
  }

  public int findMaximumXOR(int[] nums) {
    TreeNode root = new TreeNode();
    for (int num : nums) {
      TreeNode p = root;
      for (int i = 0; i < 31; ++i) {
        if ((num & 1 << 30 - i) == 0) {
          if (p.left == null)
            p.left = new TreeNode();
          p = p.left;
        } else {
          if (p.right == null)
            p.right = new TreeNode();
          p = p.right;
        }
      }
    }
    return dfs(root, root, 0);
  }

  int dfs(TreeNode n1, TreeNode n2, int level) {
    if (level == 31)
      return 0;
    if (n1.left == null || n1.right == null || n2.left == null || n2.right == null) {
      if (n1.left != null && n2.right != null) {
        return (1 << 30 - level) + dfs(n1.left, n2.right, level + 1);
      } else if (n1.right != null && n2.left != null) {
        return (1 << 30 - level) + dfs(n1.right, n2.left, level + 1);
      } else if (n1.left != null) {
        return dfs(n1.left, n2.left, level + 1);
      } else {
        return dfs(n1.right, n2.right, level + 1);
      }
    } else {
      return (1 << 30 - level)
          + Math.max(dfs(n1.left, n2.right, level + 1), dfs(n1.right, n2.left, level + 1));
    }
  }
}
