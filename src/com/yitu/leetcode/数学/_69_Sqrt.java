package com.yitu.leetcode.数学;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class _69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long i = 1;
        while (i * i < x && (i + 1) * (i + 1) <= x) {
            if(i*2*i*2<=x){
                i=i*2;
                continue;
            }
            i++;
        }
        return (int) i;
    }

    public static void main(String[] args) {
        int i = new _69_Sqrt().mySqrt(2147483647);
        System.out.println(i);
    }
}
