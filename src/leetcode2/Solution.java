package leetcode2;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}


public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    ListNode lhead;
    ListNode l = new ListNode(0);
    lhead = l;
    int flag = 0;
    while (l1 != null || l2 != null) {
      ListNode lnext = new ListNode(0);
      int a = l1 == null ? 0 : l1.val;
      int b = l2 == null ? 0 : l2.val;
      lnext.val = (a + b + flag) % 10;
      flag = (a + b + flag) / 10;
      l.next = lnext;
      l = l.next;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    if (flag != 0) // 如果还有进位，添加节点存入其中
    {
      ListNode lnext = new ListNode(0);
      lnext.val = flag;
      l.next = lnext;
    }
    return lhead.next;
  }
}
