package com.zeelam.practice.stack;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _739_Daily_Temperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null) return null;

    int[] rightBiggerIndex = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      rightBiggerIndex[i] = -1;
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        rightBiggerIndex[stack.pop()] = i;
      }
      stack.push(i);
    }
    int[] indexes = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      indexes[i] = rightBiggerIndex[i] == -1 ? 0 : rightBiggerIndex[i] - i;
    }
    return indexes;
  }

}
