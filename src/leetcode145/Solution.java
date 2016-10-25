package leetcode145;

import java.util.ArrayList;
import java.util.List;
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
  public static List<Integer> postorderTraversal(TreeNode root) {

    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> nodeStack = new Stack<>();
    Stack<Integer> nodeState = new Stack<>();

    if (root == null)
      return res;
    else {
      nodeStack.push(root);
      nodeState.push(0);
      root = root.left;
    }

    while (!nodeStack.isEmpty()) {
      while (root != null) {
        nodeStack.push(root);
        nodeState.push(0);
        root = root.left;
      }

      if (nodeState.peek() == 1) {
        res.add(nodeStack.pop().val);
        nodeState.pop();

      } else {
        root = nodeStack.peek().right;
        nodeState.pop();
        nodeState.push(1);
      }
    }
    return res;
  }
}
