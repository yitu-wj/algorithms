package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
    /**
     * 循环方式实现
     */
    public TreeNode invertTree1(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null) continue;
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return root;
    }

    /**
     * 递归的方式实现
     */
    public TreeNode invertTree2(TreeNode root){
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
    public static void main(String[] args) {

    }
}
