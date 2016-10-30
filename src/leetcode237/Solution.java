package leetcode237;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public void deleteNode(ListNode node) {
    if (node == null)
      return;
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
