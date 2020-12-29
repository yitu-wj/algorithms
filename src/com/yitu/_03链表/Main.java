package com.yitu._03链表;


import com.yitu._03链表.circle.DoubleCircleLinkedList;

public class Main {
    public static void main(String[] args) {
        josephus();
    }
    static void josephus(){
        DoubleCircleLinkedList list = new DoubleCircleLinkedList();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点（指向1）
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }
}
