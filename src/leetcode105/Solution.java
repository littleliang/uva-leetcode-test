package leetcode105;

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
  int preIndex = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0)
      return null;
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
    return createTree(preorder, 0, inorder.length - 1);
  }

  public TreeNode createTree(int[] preorder, int inStart, int inEnd) {
    if (inStart > inEnd)
      return null;
    TreeNode root = new TreeNode(preorder[preIndex++]);
    if (inStart == inEnd)
      return root;
    int inIndex = inMap.get(root.val);
    root.left = createTree(preorder, inStart, inIndex - 1);
    root.right = createTree(preorder, inIndex + 1, inEnd);
    return root;
  }
}
