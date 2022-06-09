package com.yitu.algorithms._15排序.cmp;

import com.yitu.algorithms._15排序.Sort;

/**
 * 快速排序
 * <p>
 * 执行流程
 * ① 从序列中选择一个轴点元素（pivot）
 * 假设每次选择 0 位置的元素为轴点元素
 * ② 利用 pivot 将序列分割成 2 个子序列
 * 将小于 pivot 的元素放在pivot前面（左侧）
 * 将大于 pivot 的元素放在pivot后面（右侧）
 * 等于pivot的元素放哪边都可以
 * ③ 对子序列进行 ① ② 操作
 * 直到不能再分割（子序列中只剩下1个元素）
 * <p>
 * 快速排序的本质
 * 逐渐将每一个元素都转换成轴点元素
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin,end) 范围的元素进行快速排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        // 确定轴点位置O(n)
        int mid = pivotIndex(begin, end);
        // 对子序列进行快速排序
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 构造出 [begin,end) 范围的轴点元素
     *
     * @return 轴点元素的最终位置
     */
    private int pivotIndex(int begin, int end) {
        // 随机选择一个元素跟begin位置交换
        swap(begin, begin + (int) (Math.random() * (end - begin)));

        // 备份 begin 位置的元素
        T pivot = array[begin];
        end--;

        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        // 将轴点位置放入最终的位置
        array[begin] = pivot;
        // 返回轴点元素的位置
        return begin;
    }
}
