package leetcode99;

import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  public void recoverTree(TreeNode root) {
    if (root == null)
      return;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    TreeNode last = null;
    TreeNode peak1 = null, valley1 = null, peak2 = null, valley2 = null;
    while (!stack.isEmpty()) {
      cur = stack.pop();
      if (cur.right != null) {
        TreeNode r = cur.right;
        while (r != null) {
          stack.push(r);
          r = r.left;
        }
      }
      if (last != null && cur.val < last.val) {
        if (peak1 == null) {
          peak1 = last;
          valley1 = cur;
        } else {
          peak2 = last;
          valley2 = cur;
          break;
        }
      }
      last = cur;
    }
    if (peak2 == null) {
      int val = peak1.val;
      peak1.val = valley1.val;
      valley1.val = val;
    } else {
      int val = peak1.val;
      peak1.val = valley2.val;
      valley2.val = val;
    }
  }
}
