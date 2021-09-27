package com.yitu.leetcode.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_无重复字符的最长子串 {
    // 1. 暴力解法：遍历数组的所有的区间，然后找到最长没有重复字符的区间
    // 时间复杂度：O(n^3)
    // 空间复杂度：O(n)
    // 会超时
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    // 2. 滑动窗口
    // 时间复杂度：O(2n) = O(n)，最坏的情况是 left 和 right 都遍历了一遍字符串
    // 空间复杂度：O(n)
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while (right < n) {
            char rightChar = s.charAt(right);
            while (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(rightChar);
            right++;
        }
        return maxLen;
    }
    // 3. 优化后的滑动窗口
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < n) {
            char rightChar = s.charAt(right);
            int rightCharIndex = window.getOrDefault(rightChar, 0);
            left = Math.max(left, rightCharIndex);
            maxLen = Math.max(maxLen, right - left + 1);
            window.put(rightChar, right + 1);
            right++;
        }
        return maxLen;
    }
    // 4. 追求程序的极致性能
    // s 由英文字母、数字、符号和空格组成
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int maxLen = 1;

        int left = 0, right = 0;
        int[] window = new int[128];
        while (right < n) {
            char rightChar = s.charAt(right);
            int rightCharIndex = window[rightChar];
            left = Math.max(left, rightCharIndex);
            maxLen = Math.max(maxLen, right - left + 1);
            window[rightChar] = right + 1;
            right++;
        }
        return maxLen;
    }
}
