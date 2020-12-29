package com.yitu.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_回文数 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int oldX=x;
        int result=0;
        while(x!=0){
            result=result*10+x%10;
            x=x/10;
        }
        return result==oldX;
    }
}
