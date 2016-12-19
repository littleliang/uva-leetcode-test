package leetcode297;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Codec {
  Queue<TreeNode> queue = new LinkedList<TreeNode>();
  boolean isLeft = true;
  TreeNode root = null;

  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode top = queue.poll();
      if (top == null) {
        builder.append('#');
        builder.append(',');
      } else {
        builder.append(top.val);
        builder.append(',');
        queue.offer(top.left);
        queue.offer(top.right);
      }
    }
    return builder.toString();
  }

  public TreeNode deserialize(String data) {
    String[] strs = data.split(",");
    int size = strs.length;
    for (int i = 0; i < size; i++) {
      String curstr = strs[i];
      if (curstr.length() == 0) {
        continue;
      } else if (curstr.equals("#")) {
        appendNodeToTree(null);
      } else {
        int val = Integer.parseInt(curstr);
        appendNodeToTree(new TreeNode(val));
      }
    }
    return root;
  }

  private void appendNodeToTree(TreeNode node) {
    if (root == null) {
      root = node;
      queue.offer(node);
      return;
    }
    TreeNode top = queue.peek();
    if (isLeft) {
      top.left = node;
    } else {
      top.right = node;
      queue.poll();
    }
    isLeft = !isLeft;
    if (node != null) {
      queue.offer(node);
    }
  }
}
