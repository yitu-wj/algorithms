package com.yitu.algorithms._09集合;

import com.yitu.algorithms.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set=new TreeSet<>();
        Integer[] integers=new Integer[]{1,2,3,4,5,6,7,8,9,9,9};
        for (Integer integer : integers) {
            set.add(integer);
        }
        set.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
