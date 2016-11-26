package leetcode102;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    if (root == null) {
      return list;
    }
    Deque<TreeNode> cur = new LinkedList<>();
    Deque<TreeNode> nxt = new LinkedList<>();
    TreeNode tmp;
    cur.add(root);
    while (!cur.isEmpty()) {
      List<Integer> layout = new ArrayList<>();
      while (!cur.isEmpty()) {
        tmp = cur.remove();
        if (tmp.left != null) {
          nxt.add(tmp.left);
        }
        if (tmp.right != null) {
          nxt.add(tmp.right);
        }
        layout.add(tmp.val);
      }
      cur.addAll(nxt);
      nxt.clear();
      list.add(layout);
    }
    return list;
  }
}
