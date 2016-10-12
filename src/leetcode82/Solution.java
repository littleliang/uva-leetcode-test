package leetcode82;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode helper = new ListNode(0);
    ListNode pre = helper;
    boolean isDup = false;
    while (head != null && head.next != null) {
      if (head.val == head.next.val) {
        isDup = true;
      } else if (isDup) {
        isDup = false;
      } else {
        pre.next = head;
        pre = pre.next;
      }
      head = head.next;
    }
    if (!isDup) {
      pre.next = head;
      pre = pre.next;
    } else {
      pre.next = null;
    }
    return helper.next;
  }
}
