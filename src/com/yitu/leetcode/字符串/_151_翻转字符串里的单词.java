package com.yitu.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();
        boolean space = true;
        int cur = 0;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (!space) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";
        // 反转字符串
        reverse(chars, 0, len);
        int prevSpaceIdx = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            reverse(chars, prevSpaceIdx, i);
            prevSpaceIdx = i + 1;
        }
        reverse(chars, prevSpaceIdx, len);
        return new String(chars, 0, len);
    }

    public void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
        String s = new _151_翻转字符串里的单词().reverseWords(" hello   world  ");
        System.out.println(s);
    }
}
