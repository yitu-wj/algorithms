package com.yitu.leetcode.栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈 {
    Queue<Integer> queueIn;
    Queue<Integer> queueOut;
    /** Initialize your data structure here. */
    public _225_用队列实现栈() {
        queueIn=new LinkedList<>();
        queueOut=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueIn.offer(x);
        while (!queueOut.isEmpty()){
            queueIn.offer(queueOut.poll());
        }
        Queue<Integer> tempQueue=queueIn;
        queueIn=queueOut;
        queueOut=tempQueue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queueOut.poll();
    }

    /** Get the top element. */
    public int top() {
        return queueOut.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueOut.isEmpty();
    }
}
