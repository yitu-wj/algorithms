package com.yitu.leetcode.二叉树;

import com.yitu.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int levelSize=1;
        List<Integer> layerList=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            layerList.add(node.val);
            levelSize--;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(levelSize==0){
                list.add(layerList);
                levelSize=queue.size();
                layerList=new ArrayList<>();
            }
        }
        return list;
    }
}
