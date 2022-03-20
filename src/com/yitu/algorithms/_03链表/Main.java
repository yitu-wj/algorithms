package com.yitu.algorithms._03链表;


import com.yitu.algorithms.List;
import com.yitu.algorithms._02动态数组.ArrayList;
import com.yitu.algorithms._03链表.circle.DoubleCircleLinkedList;
import com.yitu.algorithms._03链表.single.HeadLinkedList;
import com.yitu.algorithms._03链表.single.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new HeadLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(null);
        System.out.println(list);
        System.out.println(list.indexOf(null));
    }
}
