package leetcode230;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		inorderSearch(root, buffer, k);
		return buffer.get(k - 1);
	}

	public void inorderSearch(TreeNode node, ArrayList<Integer> buffer, int k) {
		if (buffer.size() >= k)
			return;
		if (node.left != null) {
			inorderSearch(node.left, buffer, k);
		}
		buffer.add(node.val);
		if (node.right != null) {
			inorderSearch(node.right, buffer, k);
		}
	}
}