package com.yitu.leetcode.数组;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 把j看成一个新数组就可以新数组第一个一定不会重复不用考虑，
 * 从第二个开始，i进行遍历，要是i等于j这个数组前一个元素，就不把它放进来，
 * 不相等时就把i这个元素放到j这个数组的下一个元素里面。
 * j代表的是新数组的下标，返回他的数组长度就是j+1.
 */
public class _26_删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int j = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[j] != nums[i]) nums[++j] = nums[i];
        return ++j;
    }
    public static void main(String[] args) {
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int[] nums={1,2,2};
//        int[] nums={1,1,2};
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.printf(nums[i]+",");
        }
    }
}
