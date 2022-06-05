package com.yitu.algorithms._15排序.cmp;

import com.yitu.algorithms._15排序.Sort;

/**
 * 插入排序-优化
 * 思路是将【交换】转为【挪动】
 * ① 先将待插入的元素备份
 * ② 头部有序数据中比待插入元素大的，都朝尾部方向挪动1个位置
 * ③ 将待插入元素放到最终的合适位置
 */
public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
