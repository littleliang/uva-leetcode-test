package leetcode160;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode p = headA;
		ListNode q = headB;
		while (p != null && q != null) {
			if(p == q){
				return p;
			}
			p = p.next;
			q = q.next;
			if(p == q){
				return p;
			}
			if (p == null){
				p = headB;
			}
			if (q == null){
				q = headA;
			}
				
		}
		return p;
	}
}
