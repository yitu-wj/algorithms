package com.yitu.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class _27_移除元素 {
    public static int removeElement(int[] nums, int val) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val) nums[j++]=nums[i];
        }
        return j;
    }
    public static void main(String[] args) {
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int[] nums={3,2,2,3};
        int len = removeElement(nums, 3);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.printf(nums[i]+",");
        }
    }
}
