package com.yitu.algorithms._15排序;

import com.yitu.algorithms._15排序.cmp.*;
import com.yitu.algorithms.tools.Asserts;
import com.yitu.algorithms.tools.Integers;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Main {
    public static void main(String[] args) {
        Integer[] array = Integers.random(20000,0,10000);

        testSorts(array,
//                new BubbleSort1(),
//                new BubbleSort2(),
                new BubbleSort3(),
//                new InsertionSort1(),
                new InsertionSort3(),
                new HeapSort(),
                new SelectionSort(),
                new MergeSort(),
                new QuickSort(),
                new ShellSort());
    }
    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
