package leetcode86;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;
    ListNode fakeNode1 = new ListNode(-1);
    ListNode fakeNode2 = new ListNode(-1);
    ListNode cur1 = fakeNode1, cur2 = fakeNode2;
    while (head != null) {
      ListNode next = head.next;
      if (head.val < x) {
        cur1.next = head;
        cur1 = cur1.next;
      } else {
        cur2.next = head;
        cur2 = cur2.next;
        cur2.next = null;
      }
      head = next;
    }
    cur1.next = fakeNode2.next;
    return fakeNode1.next;

  }
}
