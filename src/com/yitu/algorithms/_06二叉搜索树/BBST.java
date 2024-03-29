package com.yitu.algorithms._06二叉搜索树;

import java.util.Comparator;

/**
 * 平衡二叉搜索树
 */
public class BBST<E> extends BST<E> {
    public BBST() {
        this(null);
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * 左旋转
     */
    protected void rotateLeft(Node<E> grand) {
        // 交换子树
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        // 维护parent和height
        afterRotate(grand, parent, child);
    }

    /**
     * 右旋转
     */
    protected void rotateRight(Node<E> grand) {
        // 交换子树
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        // 维护parent和height
        afterRotate(grand, parent, child);
    }

    /**
     * 不管是左旋转、右旋转都是要执行的
     * @param grand     失衡节点
     * @param parent    失衡节点的tallerChild
     * @param child     grand和parent需要交换的子树（本来是parent的子树，后面变成了grand的子树）
     */
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        // 子树的根节点嫁接到原树中
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else { // grand是root节点
            root = parent;
        }

        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        // 更新grand的parent
        grand.parent = parent;
    }

    protected void rotate(
            Node<E> r, // 子树的根节点
            Node<E> a,Node<E> b,Node<E> c,
            Node<E> d,
            Node<E> e,Node<E> f,Node<E> g){
        // 让d成为这颗树的根节点
        d.parent=r.parent;
        if(r.isLeftChild()){
            r.parent.left=d;
        }else if(r.isRightChild()){
            r.parent.right=d;
        }else {
            root=d;
        }

        // a-b-c
        b.left=a;
        if(a!=null){
            a.parent=b;
        }
        b.right=c;
        if(c!=null){
            c.parent=b;
        }
        // e-f-g
        f.left=e;
        if(e!=null){
            e.parent=f;
        }
        f.right=g;
        if(g!=null){
            g.parent=f;
        }

        // b-d-f
        d.left=b;
        d.right=f;
        b.parent=d;
        f.parent=d;
    }
}
