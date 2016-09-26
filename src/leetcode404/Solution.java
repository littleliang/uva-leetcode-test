package leetcode404;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	private int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		helper(root, false);
		return sum;
	}

	private void helper(TreeNode root, boolean left) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			sum = left ? sum + root.val : sum;
			return;
		}
		helper(root.left, true);
		helper(root.right, false);
	}
}
