package leetcode173;

import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class BSTIterator {
  private Stack<TreeNode> stack = new Stack<TreeNode>();

  public BSTIterator(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode top = stack.peek();
    stack.pop();
    TreeNode temp = top.right;
    while (temp != null) {
      stack.push(temp);
      temp = temp.left;
    }
    return top.val;
  }

}
