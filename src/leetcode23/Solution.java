package leetcode23;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
      return null;
    return helper(lists, 0, lists.length - 1);
  }

  public ListNode helper(ListNode[] list, int left, int right) {
    if (left == right) {
      return list[left];
    } else {
      int mid = left + (right - left) / 2;
      ListNode one = helper(list, left, mid);
      ListNode two = helper(list, mid + 1, right);
      return merge(one, two);
    }
  }

  public ListNode merge(ListNode a, ListNode b) {
    ListNode head = new ListNode(0);
    ListNode dummy = head;
    while (a != null || b != null) {
      if (a != null && b != null) {
        if (a.val < b.val) {
          dummy.next = new ListNode(a.val);
          a = a.next;
        } else {
          dummy.next = new ListNode(b.val);
          b = b.next;
        }
      } else if (a != null) {
        dummy.next = new ListNode(a.val);
        a = a.next;
      } else {
        dummy.next = new ListNode(b.val);
        b = b.next;
      }
      dummy = dummy.next;
    }
    return head.next;
  }
}
