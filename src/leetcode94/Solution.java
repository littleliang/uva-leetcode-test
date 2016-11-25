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

/*
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if (root == null)
      return list;
    else {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode tmp = root;
      while (!(stack.empty() && tmp == null)) {
        while (tmp != null) {
          stack.push(tmp);
          tmp = tmp.left;
        }
        TreeNode tmp2 = stack.pop();
        list.add(tmp2.val);
        if (tmp2.right != null)
          tmp = tmp2.right;
      }
    }
    return list;
  }
}
*/
