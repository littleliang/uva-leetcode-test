package leetcode94;

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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    inorderTraversal(root, res);
    return res;
  }

  public void inorderTraversal(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left, res);
    res.add(root.val);
    inorderTraversal(root.right, res);
  }

}
