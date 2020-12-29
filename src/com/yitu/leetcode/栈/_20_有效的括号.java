package com.yitu.leetcode.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
        boolean valid = isValid("{[()]}");
        System.out.println(valid);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }
}
