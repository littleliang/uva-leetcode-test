package leetcode142;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}


public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != null && fast != null && slow != fast) {
      slow = slow.next;
      fast = fast.next == null ? fast.next : fast.next.next;
    }
    if (slow == fast) {
      slow = head;
      fast = fast.next;
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
    }
    return null;
  }
}
