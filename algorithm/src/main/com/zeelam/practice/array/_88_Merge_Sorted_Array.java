package com.zeelam.practice.array;

/**
 * 88. Merge Sorted Array
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
public class _88_Merge_Sorted_Array {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // num1 = [1, 3, 5, 0, 0, 0], m = 3
    // num2 = [2, 4, 6],          n = 3
    int i1 = m - 1;
    int i2 = n - 1;
    int cur = nums1.length - 1;

    while (i2 >= 0) {
      if (i1 >= 0 && nums2[i2] < nums1[i1]) {
        nums1[cur--] = nums2[i1--];
      } else {
        nums1[cur--] = nums1[i2--];
      }
    }
  }

}
