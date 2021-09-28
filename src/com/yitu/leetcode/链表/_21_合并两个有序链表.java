package com.yitu.leetcode.链表;

import com.yitu.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode;
        if (l1.val < l2.val) {
            newNode = l1;
            l1 = l1.next;
        } else {
            newNode = l2;
            l2 = l2.next;
        }
        ListNode lastNode=newNode;
        while (l1!=null&&l2!=null){
            if(l1.val< l2.val){
                lastNode.next=l1;
                lastNode=l1;
                l1=l1.next;
            }else {
                lastNode.next=l2;
                lastNode=l2;
                l2=l2.next;
            }
        }
        if(l1!=null){
            lastNode.next=l1;
        }
        if(l2!=null){
            lastNode.next=l2;
        }

        return newNode;
    }
}
