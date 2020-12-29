package com.yitu.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class _35_搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        int left=Integer.MAX_VALUE;
        int leftIndex=-1;
        for (int i = 0; i < nums.length; i++) {
            //求差
            int difference=target-nums[i];
            if(difference==0){
                return i;
            }else if(difference>0&&difference<left){
                left=difference;
                leftIndex=i;
            }
        }
        return leftIndex+1;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int index = searchInsert(nums, 0);
        System.out.println(index);
    }
}
