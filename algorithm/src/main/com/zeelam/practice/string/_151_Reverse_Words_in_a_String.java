package com.zeelam.practice.string;

/**
 * 151. Reverse Words in a String
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _151_Reverse_Words_in_a_String {

  public String reverseWords(String s) {
    if (s == null) return null;
    char[] chars = s.toCharArray();

    int cur = 0;
    int len = 0;
    boolean flag = true;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != ' ') {
        chars[cur++] = chars[i];
        flag = false;
      } else if (!flag) {
        chars[cur++] = ' ';
        flag = true;
      }
    }
    len = flag ? cur - 1 : cur;

    reverse(chars, 0, len);
    int start = 0;
    for (int i = 0; i < len; i++) {
      if (chars[i] == ' ') {
        reverse(chars, start, i);
        start = i + 1;
      }
    }
    reverse(chars, start, len);

    return new String(chars, 0, len);
  }

  private void reverse(char[] chars, int left, int right) {
    right--;
    while (left < right) {
      char tmp = chars[left];
      chars[left] = chars[right];
      chars[right] = tmp;
      left++;
      right--;
    }
  }

}
