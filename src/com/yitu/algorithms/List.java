package com.yitu.algorithms;

public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;
    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     */
    int size();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element   元素
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     * @param element   元素
     */
    void add(E element);

    /**
     * 获取index位置的元素
     * @param index     索引
     */
    E get(int index);

    /**
     * 设置index位置的元素
     * @param index     索引
     * @param element   元素
     * @return 原来的元素ֵ
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     * @param index     索引
     * @param element   元素
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index     元素
     */
    E remove(int index);

    /**
     * 查看元素的索引
     * @param element   元素
     */
    int indexOf(E element);
}
