package com.yitu._06二叉搜索树;

import com.yitu._06二叉搜索树.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator){
        this.comparator=comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void clear(){
        root=null;
        size=0;
    }

    public void add(E element){
        elementNotNullCheck(element);

        // 添加第一个节点
        if(root==null){
            root=new Node<>(element,null);
            size++;
            return;
        }
        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent=root;
        Node<E> node=root;
        int cmp=0;
        do {
            cmp=compare(element,node.element);
            parent=node;
            if(cmp>0){
                node=node.right;
            }else if(cmp<0){
                node=node.left;
            }else { // 相等
                node.element=element;
                return;
            }
        }while (node!=null);
        Node<E> newNode=new Node<>(element,parent);
        // 看看插入到父节点的哪个位置
        if(cmp>0){
            parent.right=newNode;
        }else {
            parent.left=newNode;
        }
        size++;
    }

    /**
     * 前序遍历
     */
    public void preorder(Visitor<E> visitor){
        if (visitor==null) return;
        preorder(root,visitor);
    }
    private void preorder(Node<E> node,Visitor<E> visitor){
        if(node==null|| visitor.stop)return;

        visitor.stop= visitor.visit(node.element);
        preorder(node.left,visitor);
        preorder(node.right,visitor);
    }

    /**
     * 中序遍历
     */
    public void inorder(Visitor<E> visitor){
        if(visitor==null) return;
        inorder(root,visitor);
    }
    private void inorder(Node<E> node,Visitor<E> visitor){
        if(node==null|| visitor.stop)return;

        inorder(node.left,visitor);
        if(visitor.stop)return;
        visitor.stop= visitor.visit(node.element);
        inorder(node.right,visitor);
    }

    /**
     * 后续遍历
     */
    public void postorder(Visitor<E> visitor){
        if(visitor==null)return;
        postorder(root,visitor);
    }
    private void postorder(Node<E> node,Visitor<E> visitor){
        if (node == null || visitor.stop) return;

        postorder(node.left, visitor);
        postorder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(Visitor<E> visitor){
        if(root==null||visitor==null)return;

        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(visitor.visit(node.element))return;

            if(node.left!=null){
                queue.offer(node.left);
            }

            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }


    /**
     * 返回值等于 0，代表e1和e2相等；
     * 返回值大于 0，代表e1大于e2;
     * 返回值小于 0, 代表e1小于e2
     */
    private int compare(E e1,E e2){
       if(comparator!=null){
           return comparator.compare(e1,e2);
       }
       return ((Comparable<E>)e1).compareTo(e2);
    }
    private void elementNotNullCheck(E element){
        if(element==null){
            throw new IllegalArgumentException("element must not be null");
        }
    }
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element.toString();
    }
    public static abstract class Visitor<E>{
        boolean stop;
        /**
         * @return 如果返回true , 就代表停止遍历
         */
        public abstract boolean visit(E element);
    }
    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element,Node<E> parent){
            this.element=element;
            this.parent=parent;
        }
    }
}
