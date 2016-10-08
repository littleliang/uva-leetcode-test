package leetcode103;

import java.util.Deque;
import java.util.LinkedList;
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();

		if (root == null) {
			return result;
		}
		int flag = 0;
		TreeNode node;
		List<Integer> lay = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		Deque<TreeNode> nextStack = new LinkedList<>();

		stack.add(root);

		while (!stack.isEmpty()) {
			node = stack.removeLast();

			lay.add(node.val);

			if (flag == 0) {
				if (node.left != null) {
					nextStack.addLast(node.left);
				}

				if (node.right != null) {
					nextStack.addLast(node.right);
				}
			}
			else {
				if (node.right != null) {
					nextStack.addLast(node.right);
				}

				if (node.left != null) {
					nextStack.addLast(node.left);
				}
			}

			if (stack.isEmpty()) {
				Deque<TreeNode> temp = nextStack;
				nextStack = stack;
				stack = temp;

				flag = 1 - flag;
				result.add(lay);
				lay = new LinkedList<>();
			}
		}

		return result;
	}
}
