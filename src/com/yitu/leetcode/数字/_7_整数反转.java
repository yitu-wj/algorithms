package com.yitu.leetcode.数字;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class _7_整数反转 {
    public static int reverse(int x) {
        long result=0;
        while(x!=0){
            result=result*10+x%10;
            x=x/10;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)return 0;
        return (int) result;
    }

    public static void main(String[] args) {
        int result = reverse(1534236469);
        System.out.println(result);
    }
}
