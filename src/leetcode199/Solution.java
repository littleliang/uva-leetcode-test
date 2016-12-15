package leetcode199;

import java.util.ArrayDeque;
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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);
    int count = 1;
    while (!queue.isEmpty()) {
      TreeNode temp = queue.pollFirst();
      if (temp.left != null)
        queue.addLast(temp.left);
      if (temp.right != null)
        queue.addLast(temp.right);
      count--;
      if (count == 0) {
        res.add(temp.val);
        count = queue.size();
      }
    }
    return res;
  }
}
