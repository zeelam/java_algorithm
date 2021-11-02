package com.zeelam.practice.array;

/**
 *
 * 75. Sort Colors
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _75_Sort_Colors {
  public void sortColors(int[] nums) {
    int i = 0;
    int left = 0;
    int right = nums.length - 1;
    while (i <= right) {
      int v = nums[i];
      if (v == 0) {
        swap(nums, i++, left++);
      } else if(v == 1) {
        i++;
      } else {
        swap(nums, i, right--);
      }
    }
  }

  private void swap(int[] nums, int i1, int i2) {
    int tmp = nums[i1];
    nums[i1] = nums[i2];
    nums[i2] = tmp;
  }

}
