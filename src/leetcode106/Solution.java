package leetcode106;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class Solution {
  Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
  int postIndex = 0;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0)
      return null;
    postIndex = postorder.length - 1;
    for (int i = 0; i < inorder.length; i++)
      inMap.put(inorder[i], i);
    return createTree(postorder, 0, inorder.length - 1);
  }

  TreeNode createTree(int[] postorder, int inStart, int inEnd) {
    if (inStart > inEnd || postIndex < 0)
      return null;
    TreeNode root = new TreeNode(postorder[postIndex--]);
    if (inStart == inEnd)
      return root;
    int inIndex = inMap.get(root.val);
    root.right = createTree(postorder, inIndex + 1, inEnd);
    root.left = createTree(postorder, inStart, inIndex - 1);
    return root;
  }
}
