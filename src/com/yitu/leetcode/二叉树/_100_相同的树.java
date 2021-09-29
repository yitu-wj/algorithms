package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;
        if (p == null && q == null) return true;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
