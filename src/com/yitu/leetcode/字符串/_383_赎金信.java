package com.yitu.leetcode.字符串;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class _383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int tmp = magazine.charAt(i) - 'a';
            counts[tmp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int tmp = ransomNote.charAt(i) - 'a';
            if (counts[tmp] <= 0) return false;
            counts[tmp]--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new _383_赎金信().canConstruct("aa", "aab");
        System.out.println(b);
    }
}
