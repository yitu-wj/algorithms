package com.yitu._03链表;


import com.yitu.List;
import com.yitu._03链表.circle.DoubleCircleLinkedList;

public class Main {
    public static void main(String[] args) {
        josephus();
    }
    static void josephus(){
        List<Integer> list = new DoubleCircleLinkedList<>();
        list.add(1);
        list.add(2);
    }
}
