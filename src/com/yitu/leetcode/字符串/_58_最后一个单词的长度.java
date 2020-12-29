package com.yitu.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class _58_最后一个单词的长度 {
    /**
     * 从末尾往前面判断. 需要注意末尾的空格
     */
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }
    public static void main(String[] args) {
        int length = lengthOfLastWord("hello www");
        System.out.println(length);
    }
}
