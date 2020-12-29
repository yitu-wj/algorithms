package com.yitu.leetcode.字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class _14_最长公共前缀 {
    public static void main(String[] args) {
        String prefix = longestCommonPrefix2(new String[]{"abcd","abcdef","abc"});
        System.out.println(prefix);
    }
    public static String longestCommonPrefix1(String[] strs) {
        Set<Character> set=new HashSet<>();
        StringBuilder result= new StringBuilder();
        int minLength=minLength(strs);
        for (int i = 0; i < minLength; i++) {
            set.clear();
            for (int j = 0; j < strs.length; j++) {
                set.add(strs[j].charAt(i));
            }
            if(set.size()!=1){
                return result.toString();
            }else {
                Character c = set.iterator().next();
                result.append(c.toString());
            }
        }
        return result.toString();
    }

    /**
     * 以第一个字符串为最大公共前缀，从第二个字符串开始判断是否存在该前缀，
     * 不存在时将字符串从后开始缩减直到存在，然后挨个遍历字符串数组。
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
    public static int minLength(String[] strs){
        int minLength=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length()<minLength){
                minLength=strs[i].length();
            }
        }
        return minLength;
    }

}
