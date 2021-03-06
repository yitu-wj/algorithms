package com.yitu._05队列;

import com.yitu.List;
import com.yitu._03链表.single.LinkedList;

/**
 * 优先使用双向链表，因为队列主要是往头尾操作元素
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
