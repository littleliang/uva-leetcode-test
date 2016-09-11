package leetcode92;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode listNode = null;
		while (head != null) {
			ListNode node = new ListNode(head.val);
			if (listNode != null) {
				node.next = listNode;
			}
			listNode = node;
			head = head.next;
		}
		return listNode;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode lNode;
		ListNode mNode;
		ListNode rNode;
		lNode = head;
		boolean hasL = true;
		if (m == 1) {
			hasL = false;
		}
		n -= m;
		while (--m > 1) {
			head = head.next;
		}
		if (hasL) {
			mNode = head.next;
		} else {
			mNode = head;
		}
		if (mNode == null) {
			return lNode;
		}
		ListNode temp;
		temp = mNode;
		while (n-- > 0) {
			temp = temp.next;
		}
		rNode = temp.next;
		temp.next = null;
		mNode = reverseList(mNode);
		if (hasL) {
			head.next = mNode;
		} else {
			head = mNode;
		}
		while (mNode.next != null) {
			mNode = mNode.next;
		}
		mNode.next = rNode;
		if (hasL) {
			return lNode;
		}
		return head;
	}
}
