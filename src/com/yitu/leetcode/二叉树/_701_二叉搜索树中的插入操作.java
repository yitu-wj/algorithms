package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class _701_二叉搜索树中的插入操作 {
    /**
     * 返回插入后二叉搜索树的根节点
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        int cmp;
        TreeNode parent;
        TreeNode node=root;
        do {
            cmp=val-node.val;
            parent=node;
            if(cmp>0){
                node=node.right;
            }else if(cmp<0){
                node=node.left;
            }else { // cmp == 0
                return root;
            }
        }while (node!=null);

        TreeNode newNode = new TreeNode(val, null, null);

        if(cmp>0){
            parent.right=newNode;
        }else {
            parent.left=newNode;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode oneNode=new TreeNode(1);
        TreeNode threeNode=new TreeNode(3);
        TreeNode twoNode=new TreeNode(2,oneNode,threeNode);
        TreeNode sevenNode=new TreeNode(7);
        TreeNode fourNode=new TreeNode(4,twoNode,sevenNode);

        insertIntoBST(fourNode,5);

    }
}
