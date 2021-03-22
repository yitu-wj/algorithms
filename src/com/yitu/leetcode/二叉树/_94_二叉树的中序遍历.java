package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
    /**
     * 递归的方式实现中序遍历
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder1(list,root);
        return list;
    }
    public void inorder1(List<Integer> list,TreeNode node){
        if(node==null)return;
        inorder1(list,node.left);
        list.add(node.val);
        inorder1(list,node.right);
    }

    /**
     * 迭代方式实现中序遍历
     */
    public List<Integer> inorderTraversal2(TreeNode root){
        return null;
    }
}
