package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
    /**
     * 迭代的方式计算树的最大深度
     */
    public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int levelSize=1;
        int height=0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(levelSize==0){
                height++;
                levelSize= queue.size();
            }
        }
        return height;
    }

    /**
     * 迭代的方式计算树的最大深度
     */
    public int maxDepth2(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(maxDepth2(root.left),maxDepth2(root.right));
    }
}
