package com.yitu.algorithms._05队列;

import com.yitu.algorithms._05队列.circle.CircleQueue;

public class Main {
    public static void main(String[] args) {
        CircleQueue<Integer> queue = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
