package leetcode148;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode mid = findMid(head);
    ListNode secList = mid.next;
    mid.next = null;
    return mergeList(sortList(head), sortList(secList));
  }

  public ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode mergeList(ListNode fst, ListNode sec) {
    ListNode newHead = new ListNode(0);
    ListNode tmpHead = newHead;
    while (fst != null && sec != null) {
      if (fst.val <= sec.val) {
        tmpHead.next = fst;
        fst = fst.next;
        tmpHead = tmpHead.next;
        tmpHead.next = null;
      } else {
        tmpHead.next = sec;
        sec = sec.next;
        tmpHead = tmpHead.next;
        tmpHead.next = null;
      }
    }
    tmpHead.next = (fst == null) ? sec : fst;
    return newHead.next;
  }
}
