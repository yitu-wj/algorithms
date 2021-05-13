package com.yitu._07AVL树;

import com.yitu._06二叉搜索树.BBST;

import java.util.Comparator;

/**
 * 平衡AVL树
 */
public class AVLTree<E> extends BBST<E> {
    public AVLTree(){
        this(null);
    }
    public AVLTree(Comparator<E> comparator){
        super(comparator);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node=node.parent)!=null){
            if(isBalanced(node)){
                // 更新高度
                updateHeight(node);
            }else {
                // 恢复平衡
                reBalance(node);
                // 整树恢复平衡
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                // 更新高度
                updateHeight(node);
            } else {
                // 恢复平衡
                reBalance(node);
            }
        }
    }

    /**
     * 恢复平衡
     * @param grand 高度最低的那个不平衡节点
     */
    private void reBalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if(parent.isLeftChild()){ // L
            if(node.isLeftChild()){ // LL
//                rotateRight(grand);
                rotate(grand,node.left,node,node.right,parent,parent.right,grand,grand.right);
            }else { // LR
//                rotateLeft(parent);
//                rotateRight(grand);
                rotate(grand,parent.left,parent,node.left,node,node.right,grand,grand.right);
            }
        }else { // R
            if(node.isLeftChild()){ // RL
//                rotateRight(parent);
//                rotateLeft(grand);
                rotate(grand,grand.left,grand,node.left,node,node.right,parent,parent.right);
            }else { // RR
//                rotateLeft(grand);
                rotate(grand,grand.left,grand,parent.left,parent,node.left,node,node.right);
            }
        }
    }

    @Override
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        super.afterRotate(grand, parent, child);
        // 更新高度
        updateHeight(grand);
        updateHeight(parent);
    }

    @Override
    protected void rotate(Node<E> r, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        super.rotate(r, a, b, c, d, e, f, g);

        // 更新高度
        updateHeight(b);
        updateHeight(f);
        updateHeight(d);

    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }
    private boolean isBalanced(Node<E> node){
        return Math.abs(((AVLNode<E>)node).balanceFactor())<=1;
    }
    private static class AVLNode<E> extends Node<E>{
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }
        /**
         * 计算平衡因子
         */
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        /**
         * 跟新树的高度
         */
        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * 左右子树最高的那个节点
         */
        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            // leftHeight == rightHeight
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }
    }
}
