package leetcode25;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k == 1)
      return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode begin = dummy;
    int count = 0;
    while (head != null) {
      count++;
      if (count % k == 0) {
        begin = reverseList(begin, head.next);
        head = begin.next;
      } else {
        head = head.next;
      }

    }
    return dummy.next;
  }

  public ListNode reverseList(ListNode begin, ListNode end) {
    ListNode curr = begin.next;
    ListNode first = curr;
    ListNode prev = begin;
    ListNode next;
    while (curr != end) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    begin.next = prev;
    first.next = curr;
    return first;
  }
}
