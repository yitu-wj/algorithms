package com.yitu.leetcode.数组;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/asteroid-collision/
 */
public class _735_行星碰撞 {
    public int[] asteroidCollision1(int[] asteroids) {
        int length = asteroids.length;
        int index1 = 0;
        int index2 = 1;
        while (index2 < length) {
            if (asteroids[index1] > 0 && asteroids[index2] < 0) {
                if (Math.abs(asteroids[index1]) == Math.abs(asteroids[index2])) {
                    for (int i = index1; i < length - 2; i++) {
                        asteroids[i] = asteroids[i + 2];
                    }
                    length -= 2;
                    if(index1>0){
                        index1--;
                        index2--;
                    }
                } else {
                    int tmpIndex = Math.abs(asteroids[index1]) < Math.abs(asteroids[index2]) ? index1 : index2;
                    if (index1>0&&Math.abs(asteroids[index2]) > Math.abs(asteroids[index1]) && asteroids[index1 - 1] > 0) {
                        index1--;
                        index2--;
                    }
                    for (int i = tmpIndex; i < length - 1; i++) {
                        asteroids[i] = asteroids[i + 1];
                    }
                    length -= 1;
                }
            } else {
                index1++;
                index2++;
            }
        }
        int[] result = new int[length];
        System.arraycopy(asteroids, 0, result, 0, length);
        return result;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = new _735_行星碰撞().asteroidCollision(new int[]{3, -1, -1, -2});
        System.out.println(Arrays.toString(result));
    }
}
