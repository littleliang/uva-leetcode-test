package leetcode117;

class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;

  TreeLinkNode(int x) {
    val = x;
  }
}


public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null)
      return;

    TreeLinkNode parent = root;

    while (parent != null) {

      TreeLinkNode next = null;

      while (parent != null) {
        if (next == null)
          next = getNextParentNode(parent);
        TreeLinkNode newParent = connectWithNonNullNode(parent, parent.left);
        parent =
            parent == newParent ? connectWithNonNullNode(parent.next, parent.right) : newParent;
      }

      parent = next;
    }

  }

  private TreeLinkNode getNextParentNode(TreeLinkNode cParent) {
    return cParent.left != null ? cParent.left : cParent.right;
  }

  private TreeLinkNode connectWithNonNullNode(TreeLinkNode parent, TreeLinkNode node) {

    while (node != null && parent != null) {
      if (parent.left != null && parent.left != node) {
        node.next = parent.left;
        break;
      }
      if (parent.right != null && parent.right != node) {
        node.next = parent.right;
        break;
      }
      parent = parent.next;
    }

    return parent;
  }

}
