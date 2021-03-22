package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class _98_验证二叉搜索树 {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        TreeNode threeNode=new TreeNode(3);
        TreeNode sixNode=new TreeNode(6);
        TreeNode oneNode=new TreeNode(1);
        TreeNode fourNode=new TreeNode(4,threeNode,sixNode);
        TreeNode fiveNode=new TreeNode(5,oneNode,fourNode);
        boolean result = isValidBST(fiveNode);
        System.out.println(result);
    }
}
