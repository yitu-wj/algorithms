package com.yitu.algorithms._15排序.cmp;

import com.yitu.algorithms._15排序.Sort;

/**
 * 归并排序
 * 执行流程
 * ① 不断地将当前序列平均分割成2个子序列
 * 直到不能再分割（序列中只剩1个元素）
 * ② 不断地将2个子序列合并成一个有序序列
 * 直到最终只剩下1个有序序列
 */
@SuppressWarnings("unchecked")
public class MergeSort <T extends Comparable<T>> extends Sort<T> {
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }
    // T(n) = T(n/2) + T(n/2) + O(n)

    /**
     * 对 [begin, end) 范围的数据进行归并排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     */
    private void merge(int begin, int mid, int end) {
        // 左边数组（基于leftArray）
        int li = 0, le = mid - begin;
        // 右边数组（基于array）
        int ri = mid, re = end;
        // array索引
        int ai = begin;

        // 备份左边数组 拷贝左边数组到leftArray
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

        // 如果左边还没有结束
        while (li < le) {
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                // 拷贝右边数组到array
                array[ai++] = array[ri++];
            } else {
                // 拷贝左边数组到array
                array[ai++] = leftArray[li++];
            }
        }
        // cmp位置改为 <= 会失去稳定性
    }
}
