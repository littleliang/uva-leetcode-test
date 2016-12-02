package leetcode147;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode insertionSortList(ListNode head) {
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode p = head;
    ListNode q;
    ListNode r;
    while (p != null && p.next != null) {
      if (p.val <= p.next.val) {
        p = p.next;
      } else {
        q = p.next;
        p.next = q.next;
        r = root;
        while (r.next.val <= q.val) {
          r = r.next;
        }
        q.next = r.next;
        r.next = q;
      }
    }
    return root.next;
  }
}
