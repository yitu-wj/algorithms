package com.yitu.leetcode.贪心;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class _455_分发饼干 {
    public static void main(String[] args) {
        int count = new _455_分发饼干().findContentChildren(
                new int[]{1,2,3},
                new int[]{3}
        );
        System.out.println(count);
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex=0;
        int count=0;
        for(int gIndex=0;gIndex<g.length;gIndex++){
            while (sIndex<s.length){
                if(s[sIndex]>=g[gIndex]){
                    count++;
                    sIndex++;
                    break;
                }
                sIndex++;
            }
        }
        return count;
    }
}
