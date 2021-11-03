package com.zeelam.practice.tree;

import java.util.Stack;

/**
 * 654. Maximum Binary Tree
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 *
 * Input: nums = [3,2,1,6,0,5]
 * Output: [6,3,5,null,2,0,null,null,1]
 * Explanation: The recursive calls are as follow:
 * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
 *     - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
 *         - Empty array, so no child.
 *         - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
 *             - Empty array, so no child.
 *             - Only one element, so child is a node with value 1.
 *     - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
 *         - Only one element, so child is a node with value 0.
 *         - Empty array, so no child.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _654_Maximum_Binary_Tree {

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

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null) return null;
    return findRoot(nums, 0, nums.length);
  }

  private TreeNode findRoot(int[] nums, int left, int right) {
    if (left <= right) return null;
    int maxIdx = left;
    for (int i = left + 1; i < right; i++) {
      if (nums[i] > nums[maxIdx]) maxIdx = i;
    }
    TreeNode root = new TreeNode(nums[maxIdx]);
    root.left = findRoot(nums, left, maxIdx);
    root.right = findRoot(nums, maxIdx + 1, right);
    return root;
  }

  public int[] parentIndexes(int[] nums) {
    if (nums == null) return null;
    int[] leftBiggestIndex = new int[nums.length];
    int[] rightBiggestIndex = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
      rightBiggestIndex[i] = -1;
      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        rightBiggestIndex[stack.pop()] = i;
      }
      leftBiggestIndex[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    int[] parentIndex = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (leftBiggestIndex[i] == -1 && rightBiggestIndex[i] == -1) {
        parentIndex[i] = -1;
        continue;
      }
      if (leftBiggestIndex[i] == -1) {
        parentIndex[i] = rightBiggestIndex[i];
      } else if (rightBiggestIndex[i] == -1) {
        parentIndex[i] = leftBiggestIndex[i];
      } else if (nums[leftBiggestIndex[i]] < nums[rightBiggestIndex[i]]) {
        parentIndex[i] = leftBiggestIndex[i];
      } else {
        parentIndex[i] = rightBiggestIndex[i];
      }
    }
    return parentIndex;
  }


}
