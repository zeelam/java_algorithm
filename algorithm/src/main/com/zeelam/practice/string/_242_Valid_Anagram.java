package com.zeelam.practice.string;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _242_Valid_Anagram {

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null) return false;
    if (s.length() != t.length()) return false;
    int[] counts = new int[26];
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    for (int i = 0; i < sChars.length; i++) {
      counts[sChars[i] - 'a']++;
    }
    for (int i = 0; i < tChars.length; i++) {
      if (--counts[tChars[i] - 'a'] < 0) return false;
    }
    return true;
  }

}
