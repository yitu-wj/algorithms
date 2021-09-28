package com.yitu.leetcode.数字;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class _66_加一 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        int index=digits.length-1;
        while (index>=0&&digits[index]==9){
            digits[index]=0;
            index--;
        }
        if(index==-1){
            int[] newDigits=new int[digits.length+1];
            for(int i=0;i<digits.length;i++){
                newDigits[i+1]=digits[i];
            }
            newDigits[0]++;
            return newDigits;
        }
        digits[index]++;
        return digits;
    }

    public static void main(String[] args) {
        int[] num = new _66_加一().plusOne(new int[]{1,2,2,5});
        System.out.println(Arrays.toString(num));
    }
}
