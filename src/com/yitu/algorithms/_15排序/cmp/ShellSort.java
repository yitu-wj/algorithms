package com.yitu.algorithms._15排序.cmp;

import com.yitu.algorithms.List;
import com.yitu.algorithms._02动态数组.ArrayList;
import com.yitu.algorithms._03链表.single.LinkedList;
import com.yitu.algorithms._15排序.Sort;

/**
 * 希尔排序
 * <p>
 * 执行流程
 * 希尔排序把序列看作是一个矩阵，分成 𝑚 列，逐列进行排序
 * 𝑚 从某个整数逐渐减为1
 * 当 𝑚 为1时，整个序列将完全有序
 * <p>
 * 因此，希尔排序也被称为递减增量排序（Diminishing Increment Sort）
 * <p>
 * 矩阵的列数取决于步长序列（step sequence）
 * 比如，如果步长序列为{1,5,19,41,109,...}，就代表依次分成109列、41列、19列、5列、1列进行排序
 * 不同的步长序列，执行效率也不同
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        List<Integer> stepSequence = sedgeWickStepSequence();
        for (int i = 0; i < stepSequence.size(); i++) {
            Integer step = stepSequence.get(i);
            sort(step);
        }
    }

    /**
     * 使用插入排序
     * 分成step列进行排序
     */
    private void sort(int step) {
        // col : 第几列，column的简称
        for (int col = 0; col < step; col++) { // 对第col列进行排序
            // col+0*step、col+1*step、col+2*step、col+3*step
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }

    /**
     * 目前已知的最好的步长序列，最坏情况时间复杂度是 O(n4/3) ，1986年由Robert SedgeWick提出
     */
    private List<Integer> sedgeWickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }
}
