package leetcode144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		preorderTraversal(root, res);
		return res;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> res){
		if(root == null){
			return;
		}
		res.add(root.val);
		preorderTraversal(root.left, res);
		preorderTraversal(root.right, res);
	}
}
