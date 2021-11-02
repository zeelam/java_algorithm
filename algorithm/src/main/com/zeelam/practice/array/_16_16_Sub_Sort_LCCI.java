package com.zeelam.practice.array;

/**
 * 面试题 16.16. Sub Sort LCCI
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 *
 * Given an array of integers, write a method to find indices m and n such that if you sorted elements m through n, the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).
 *
 * Return [m,n]. If there are no such m and n (e.g. the array is already sorted), return [-1, -1].
 *
 * Input:  [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * Output:  [3,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _16_16_Sub_Sort_LCCI {
  public int[] subSort(int[] array) {
    if (array.length <= 1) return new int[]{-1, -1};

    int left = 0;
    int rightIndex = -1;
    int max = array[0];
    while (left < array.length) {
      if (array[left] >= max) {
        max = array[left];
      } else {
        rightIndex = left;
      }
      left++;
    }

    if (rightIndex == -1) return new int[]{-1, -1};

    int leftIndex = -1;
    int right = array.length - 1;
    int min = array[array.length - 1];
    while (right >= 0) {
      if (array[right] <= min) {
        min = array[right];
      } else {
        leftIndex = right;
      }
      right--;
    }
    return new int[]{leftIndex, rightIndex};
  }
}
