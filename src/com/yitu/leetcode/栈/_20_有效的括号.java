package com.yitu.leetcode.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
        boolean valid = isValid1("{[()]}");
        System.out.println(valid);
    }
    public static boolean isValid1(String s){
        while (s.contains("{}")
                ||s.contains("[]")
                ||s.contains("()")){
            s=s.replace("{}","");
            s=s.replace("()","");
            s=s.replace("[]","");
        }
        return s.isEmpty();
    }

    /**
     * 栈的方式实现
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }

    /**
     * 栈的方式实现
     */
    public static boolean isValid3(String s){
        // 1. 遇见左字符，将左字符入栈
        // 2. 遇见右字符
        // * 如果栈是空的，说明括号无效
        // * 如果栈不为空，将栈顶字符出栈，于右字符之匹配
        // 如果左右字符不匹配，说明括号无效
        // 如果左右字符匹配，继续扫描下一个字符
        // 3. 所有字符扫描完毕后
        // 栈为空，说明括号有效
        // 栈不为空，说明括号无效
        Stack<Character> stack=new Stack<>();
        int length = s.length();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                // 遇见左字符，将左字符入栈
                stack.push(c);
            }else {
                // 遇见右字符
                // 如果栈是空的，说明括号无效
                if(stack.isEmpty()) return false;
                char left=stack.pop();
                // 如果栈不为空，将栈顶字符出栈，于右字符之匹配
                // 如果左右字符不匹配，说明括号无效
                // 如果左右字符匹配，继续扫描下一个字符
                if(left=='('&&c!=')') return false;
                if(left=='{'&&c!='}') return false;
                if(left=='['&&c!=']') return false;
            }
        }
        // 所有字符扫描完毕后
        // 栈为空，说明括号有效
        // 栈不为空，说明括号无效
        return stack.isEmpty();
    }
}
