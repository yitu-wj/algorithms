package com.yitu.leetcode.分治;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int max = new _53_最大子序和().maxSubArray(nums);
        System.out.println(max);
    }
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length);
    }
    /**
     * 求解[begin, end)中最大连续子序列的和
     * T(n) = T(n/2) + T(n/2) + O(n)
     * T(n) = 2T(n/2) + O(n)
     * logba = 1  d = 1
     */
    int maxSubArray(int[] nums, int begin, int end) {
        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) >> 1;
        int leftMax = nums[mid - 1];
        int leftSum = leftMax;
        for (int i = mid - 2; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = nums[mid];
        int rightSum = rightMax;
        for (int i = mid + 1; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return Math.max(leftMax + rightMax,
                Math.max(
                        maxSubArray(nums, begin, mid),
                        maxSubArray(nums, mid, end))
        );
    }
}
