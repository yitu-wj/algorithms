package com.yitu.leetcode.链表;

import com.yitu.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode lastNode = head;
        ListNode indexNode = head;
        while (indexNode != null) {
            if (lastNode.val != indexNode.val) {
                lastNode.next = indexNode;
                lastNode = indexNode;
            }
            indexNode = indexNode.next;
            if (indexNode == null) {
                lastNode.next = null;
            }
        }
        return head;
    }
}
