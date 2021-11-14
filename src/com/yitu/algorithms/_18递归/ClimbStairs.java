package com.yitu.algorithms._18递归;

/**
 * 爬楼梯
 */
public class ClimbStairs {
	
	int climbStairs(int n) {
		if (n <= 2) return n;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
}
