package leetcode95;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<TreeNode>();
    }
    return generate(1, n);
  }

  public List<TreeNode> generate(int start, int end) {
    List<TreeNode> list = new ArrayList<TreeNode>();
    if (start > end) {
      list.add(null);
      return list;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> left = generate(start, i - 1);
      List<TreeNode> right = generate(i + 1, end);
      for (TreeNode leftT : left) {
        for (TreeNode rightT : right) {
          TreeNode root = new TreeNode(i);
          root.left = leftT;
          root.right = rightT;
          list.add(root);
        }
      }
    }
    return list;
  }
}
