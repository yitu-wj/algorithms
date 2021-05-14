package com.yitu._08红黑树;

import com.yitu.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        RBTree<Integer> rbTree= new RBTree<>();
        Integer[] integers=new Integer[]{85, 37, 89, 56, 64, 93, 99, 53, 69, 68, 39, 3, 43, 52, 60, 100, 31, 79};
        for (Integer integer : integers) {
            rbTree.add(integer);
        }
        BinaryTrees.println(rbTree);
        rbTree.remove(89);
        rbTree.remove(93);
        BinaryTrees.println(rbTree);
    }
}
