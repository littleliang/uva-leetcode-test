package leetcode19;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode fast = head;
    	ListNode slow = head;
    	for(int i = 0; i < n; i++){
    		if (fast.next != null){
    			fast = fast.next;
    		}
    		else{
    			if(i == n - 1){
    				ListNode temp = head.next;
    		    	head.next = null;
    		    	head = null;
    		        return temp;
    			}
    			return null;
    		}
    	}
    	while(fast.next != null){
    		fast = fast.next;
    		slow = slow.next;
    	}
    	if (slow.next == null){
    	    slow = null;
    	    return head;
    	}
    	ListNode temp = slow.next;
    	slow.next = temp.next;
    	temp.next = null;
    	temp = null;
        return head;
    }
}
