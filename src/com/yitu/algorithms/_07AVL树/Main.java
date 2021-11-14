package com.yitu.algorithms._07AVL树;

import com.yitu.algorithms.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree=new AVLTree<>();
        int[] data=new int[]{1,2,3,4,5,6,7,8};
        for (int val : data) {
            avlTree.add(val);
        }
        BinaryTrees.println(avlTree);
        avlTree.remove(6);
        BinaryTrees.println(avlTree);
    }
}
