package com.yitu._08红黑树;

import com.yitu._06二叉搜索树.BST;

import java.util.Comparator;

public class RBTree<E> extends BST<E> {
    private static final boolean RED=false;
    private static final boolean BLACK=true;
    public RBTree(){
        this(null);
    }

    public RBTree(Comparator<E> comparator){
        super(comparator);
    }
    private Node<E> color(Node<E> node,boolean color){
        if(node==null)return null;
        ((RBNode<E>)node).color=color;
        return node;
    }

    private Node<E> red(Node<E> node){
        return color(node,RED);
    }

    private Node<E> black(Node<E> node){
        return color(node,BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node==null?BLACK:((RBNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node)==BLACK;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node)==RED;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    private static class RBNode<E> extends Node<E>{
        boolean color=RED;
        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str="";
            if(color==RED){
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
