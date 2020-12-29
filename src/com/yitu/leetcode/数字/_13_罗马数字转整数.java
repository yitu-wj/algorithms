package com.yitu.leetcode.数字;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class _13_罗马数字转整数 {
    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println(result);
    }
    public static int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int index=0;
        int result=0;
        while(index<s.length()){
            int one = map.get(s.charAt(index));
            int two = (index==s.length()-1)?0:map.get(s.charAt(index+1));
            if(one<two){
                result+=(two-one);
                index+=2;
                continue;
            }
            result+=one;
            index++;
        }
        return result;
    }
}
