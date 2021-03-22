package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postorder(list,root);
        return list;
    }
    public void postorder(List<Integer> list,TreeNode node){
        if(node==null) return;
        postorder(list,node.left);
        postorder(list,node.right);
        list.add(node.val);
    }
}
