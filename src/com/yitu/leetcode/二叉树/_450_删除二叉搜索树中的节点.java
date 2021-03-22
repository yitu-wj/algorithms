package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点 {
    /**
     *
     * @param root  根节点
     * @param key   值
     * @return      返回二叉搜索树（有可能被更新）的根节点的引用。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    /*
      One step right and then always left
      */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }
}
