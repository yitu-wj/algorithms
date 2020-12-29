package com.yitu.leetcode.数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int expect=target-nums[i];
            if(map.containsKey(expect)){
                return new int[]{map.get(expect),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] indexs = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(indexs));
    }
}
