package leetcode382;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  private ListNode head;

  public Solution(ListNode head) {
    this.head = head;
  }

  public int getRandom() {
    ListNode node = head;
    int res = head.val;
    for (int i = 1; node != null; i++) {
      if ((int) (1 + Math.random() * Integer.MAX_VALUE) % i == 0) {
        res = node.val;
      }
      node = node.next;
    }
    return res;
  }
}
