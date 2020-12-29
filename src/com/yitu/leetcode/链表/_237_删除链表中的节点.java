package com.yitu.leetcode.链表;

import com.yitu.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {
    // node表示的是要删除的结点
    public void deleteNode(ListNode node) {
        // 因为无法访问前一个结点，所有可以把要删除的结点的后一个结点的值前移
        node.val=node.next.val;
        // 然后删除掉后一个结点
        node.next=node.next.next;
    }
}
