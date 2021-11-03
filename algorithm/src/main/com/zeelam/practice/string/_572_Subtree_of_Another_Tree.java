package com.zeelam.practice.string;

/**
 * 572. Subtree of Another Tree
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _572_Subtree_of_Another_Tree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
    }
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
   if (root == null || subRoot == null) return false;
    return postOrder(root).contains(postOrder(subRoot));
  }

  private String postOrder(TreeNode root) {
    if (root == null) return "#!";
    String leftStr = postOrder(root.left);
    String rightStr = postOrder(root.right);
    return leftStr + rightStr + root.val + "!";
  }

}
