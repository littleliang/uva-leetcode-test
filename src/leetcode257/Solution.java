package leetcode257;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		StringBuilder sb = new StringBuilder();
		rec(root, res, sb);
		return res;
	}

	private void rec(TreeNode root, List<String> res, StringBuilder sb) {
		if (root.left == null && root.right == null) {
			sb.append(root.val);
			res.add(sb.toString());
			return;
		}

		sb.append(root.val);
		sb.append("->");
		int oriLen = sb.length();

		if (root.left != null)
			rec(root.left, res, sb);
		sb.setLength(oriLen);
		if (root.right != null)
			rec(root.right, res, sb);

	}
}
