package leetcode24;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode root = new ListNode(-1);
		root.next = head;
		ListNode pre_head = root;
		while (head != null && head.next != null) {
			ListNode Node1 = head;
			ListNode Node2 = head.next.next;
			root.next = head.next;
			root = root.next;
			root.next = Node1;
			Node1.next = Node2;
			root = root.next;
			head = Node2;

		}
		return pre_head.next;
	}
}
