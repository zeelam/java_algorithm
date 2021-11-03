package com.zeelam.practice.string;

/**
 * 面试题 01.09. String Rotation LCCI
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 *
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat").Can you use only one call to the method that checks if one word is a substring of another?
 *
 * Input: s1 = "waterbottle", s2 = "erbottlewat"
 * Output: True
 *
 * Input: s1 = "aa", s2 = "aba"
 * Output: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _01_09_String_Rotation_LCCI {

  public boolean isFlippedString(String s1, String s2) {
    if (s1 == null || s2 == null) return false;
    if (s1.length() != s2.length()) return false;
    return (s1 + s1).contains(s2);
  }

}
