package com.yitu.algorithms;

import com.yitu.algorithms.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
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
     * 判断当前二叉树是为完全二叉树
     */
    public boolean isComplete(){
        if(root==null) return false;

        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);

        boolean leaf=false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(leaf&&!node.isLeaf()) return false;

            if(node.left!=null){
                queue.add(node.left);
            }else if(node.right!=null){ // node.left == null && node.right != null
                return false;
            }

            if(node.right!=null){
                queue.add(node.right);
            }else { // node.right == null
                leaf=true;
            }
        }
        return true;
    }

    /**
     * 计算树的高度
     * @return  树的高度
     */
    public int height(){
        if(root==null) return 0;

        // 树的高度
        int height=0;
        // 存储着每一层的元素数量
        int levelSize=1;
        Queue<Node<E>> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize--;

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

            if(levelSize==0){
                levelSize=queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 通过递归的方式返回树的高度
     */
    public int height2(){
        return height2(root);
    }
    private int height2(Node<E> node){
        if(node==null) return 0;
        return 1+Math.max(height2(node.left),height2(node.right));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root,sb,"");
        return sb.toString();
    }
    private void toString(Node<E> node,StringBuilder sb,String prefix){
        if(node==null)return;

        toString(node.left,sb,prefix+"L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right,sb,prefix+"R---");
    }


    protected Node<E> createNode(E element,Node<E> parent){
        return new Node<>(element, parent);
    }

    /**
     * 查找指定节点的前驱节点，如果没有则返回null
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;

        // 前驱节点在左子树当中（left.right.right.right....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }

    /**
     * 查找指定节点的后驱节点，如果没有则返回null
     */
    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;

        // 前驱节点在左子树当中（right.left.left.left....）
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
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
        return ((Node)node).element;
    }
    public static abstract class Visitor<E>{
        boolean stop;
        /**
         * @return 如果返回true , 就代表停止遍历
         */
        public abstract boolean visit(E element);
    }
    public static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<E> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }

            return null;
        }
    }
}
