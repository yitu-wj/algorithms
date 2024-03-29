package com.yitu.algorithms._12堆;

import com.yitu.algorithms.AbstractHeap;
import com.yitu.algorithms.printer.BinaryTreeInfo;

import java.util.Collection;
import java.util.Comparator;

/**
 * 二叉堆（最大堆）
 */
@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY =10;

    public BinaryHeap(E[] elements, Comparator<E> comparator){
        super(comparator);

        if (elements == null || elements.length == 0) {
            this.elements= (E[]) new Object[DEFAULT_CAPACITY];
        }else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(Collection<E> elements,Comparator<E> comparator){
        super(comparator);

        size=elements==null?0: elements.size();
        if(size==0){
            this.elements= (E[]) new Object[DEFAULT_CAPACITY];
        }else {
            int capacity=Math.max(size,DEFAULT_CAPACITY);
            this.elements= (E[]) new Object[capacity];
            int i=0;
            for (E element : elements) {
                this.elements[i++]=element;
            }
        }
    }

    public BinaryHeap(E[] elements){
        this(elements,null);
    }

    public BinaryHeap(Comparator<E> comparator){
        this((Collection<E>) null,comparator);
    }

    public BinaryHeap(){
        this((Collection<E>) null,null);
    }

    /**
     * 批量建堆
     */
    private void heapify() {
        // 自上而下的上滤
//		for (int i = 1; i < size; i++) {
//			siftUp(i);
//		}

        // 自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    public void addAll(Collection<E> elements) {
        if (elements == null) return;
        for (E element : elements) {
            add(element);
        }
    }

    public void addAll(E[] elements) {
        if (elements == null) return;
        for (E element : elements) {
            add(element);
        }
    }


    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();

        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;

        siftDown(0);
        return root;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);

        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    /**
     * 让index位置的元素下溢
     */
    private void siftDown(int index){
        E element=elements[index];
        // 第一个叶子节点的索引 == 非叶子节点的数量
        // index < 第一个叶子节点的索引
        // 必须保证index位置是非叶子节点
        int half=size>>1;
        while (index<half){
            // index 的节点有两种情况
            // 1. 只有左叶子节点
            // 2. 同时有左右子节点

            // 默认为左叶子节点跟它比较
            int childIndex=(index<<1)+1;
            E child=elements[childIndex];

            // 右节点
            int rightIndex=childIndex+1;

            // 选出左右子节点最大的那个
            if(rightIndex<size && compare(elements[rightIndex],child)>0){
                child=elements[childIndex=rightIndex];
            }
            if(compare(element,child)>=0) break;

            // 将子节点存到index位置
            elements[index]=child;
            index=childIndex;
        }
        elements[index]=element;
    }

    /**
     * 让index位置的元素上溢
     */
    private void siftUp(int index){
        E element=elements[index];
        while (index>0){
            int parentIndex=(index-1)>>1;
            E parent=elements[parentIndex];
            if(compare(element,parent)<=0) break;

            // 将父元素存储在index位置
            elements[index]=parent;

            // 重新赋值index
            index=parentIndex;
        }
        elements[index]=element;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int)node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int)node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int)node];
    }

}
