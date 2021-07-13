package com.yitu.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class _88_合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] leftArray=new int[m];
        int li=0,le=m;
        int ri=0,re=n;
        int ai=0;
        // 备份nums1数组
        for(int i=0;i<m;i++){
            leftArray[i]=nums1[i];
        }
        while (li<le&&ri<re){
            if(leftArray[li]<nums2[ri]){
                nums1[ai++]=leftArray[li++];
            }else {
                nums1[ai++]=nums2[ri++];
            }
        }
        while (li<le){
            nums1[ai++]=leftArray[li++];
        }
        while (ri<re){
            nums1[ai++]=nums2[ri++];
        }
    }

    public static void main(String[] args) {
        int[] num1={1,2,3,0,0,0};
        int m=3;
        int[] num2={2,5,6};
        int n=3;
        merge(num1,m,num2,n);
    }
}
