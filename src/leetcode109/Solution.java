package leetcode109;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


public class Solution {
  private ListNode temp;

  public TreeNode sortedListToBST(ListNode head) {
    int length = 0;
    ListNode node = head;
    while (node != null) {
      length++;
      node = node.next;
    }
    temp = head;
    return sortedListToBST(0, length - 1);
  }

  public TreeNode sortedListToBST(int start, int end) {
    if (start > end)
      return null;
    int mid = start + (end - start) / 2;
    TreeNode left = sortedListToBST(start, mid - 1);
    TreeNode parent = new TreeNode(temp.val);
    parent.left = left;
    temp = temp.next;
    TreeNode right = sortedListToBST(mid + 1, end);
    parent.right = right;
    return parent;
  }
}
