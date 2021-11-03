package com.zeelam.practice.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _3_Longest_Substring_Without_Repeating_Characters {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) return 0;
    if (s.length() < 2) return s.length();

    char[] chars = s.toCharArray();
    Map<Character, Integer> piMap = new HashMap<>();
    piMap.put(chars[0], 0);
    int li = 0;
    int max = 1;
    for (int i = 1; i < chars.length; i++) {
      Integer pi = piMap.getOrDefault(chars[i], -1);
      if (li <= pi) {
        li = pi + 1;
      }
      piMap.put(chars[i], i);
      max = Math.max(max, i - li + 1);
    }
    return max;
  }

}
