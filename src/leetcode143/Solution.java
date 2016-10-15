package leetcode143;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}


public class Solution {
  public ListNode inverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode dumny = new ListNode(-1);
    ListNode p = head;
    ListNode cur;
    while (p != null) {
      cur = p;
      p = p.next;
      cur.next = dumny.next;
      dumny.next = cur;
    }
    return dumny.next;
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
      return;
    ListNode p = head;
    ListNode q = head;
    ListNode tmp = null;
    while (q != null) {
      tmp = p;
      p = p.next;
      if (q.next != null)
        q = q.next.next;
      else {
        tmp.next = null;
        break;
      }
      if (q == null)
        tmp.next = null;
    }
    q = inverseList(p);
    p = head;
    while (p != null && q != null) {
      tmp = q.next;
      q.next = p.next;
      p.next = q;
      q = tmp;
      p = p.next.next;
    }
  }
}
