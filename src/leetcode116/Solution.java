package leetcode116;

import java.util.ArrayDeque;

class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;

  TreeLinkNode(int x) {
    val = x;
  }
}


public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    ArrayDeque<TreeLinkNode> queue = new ArrayDeque<>();
    queue.addLast(root);
    int count = 1;
    while (!queue.isEmpty()) {
      TreeLinkNode temp = queue.pollFirst();
      if (temp.left != null)
        queue.addLast(temp.left);
      if (temp.right != null)
        queue.addLast(temp.right);
      count--;
      if (count == 0) {
        temp.next = null;
        count = queue.size();
      } else {
        temp.next = queue.peekFirst();
      }
    }
    return;
  }
}
