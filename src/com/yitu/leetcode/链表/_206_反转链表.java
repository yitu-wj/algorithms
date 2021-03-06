package com.yitu.leetcode.链表;

import com.yitu.leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {
    /**
     * 迭代方式
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode newNode=null;
        while(head!=null){
            ListNode tempNode=head.next;
            head.next=newNode;
            newNode=head;
            head=tempNode;
        }
        return newNode;
    }

    /**
     * 递归方式
     */
    public static ListNode reverseList1(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        // ******简单推算******
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // step1
        // 1 -> 2 -> 3 -> 4 <- 5
        // step2
        // 1 -> 2 -> 3 <- 4 <- 5
        // step3
        // 1 -> 2 <- 3 <- 4 <- 5
        // step4
        // null <- 1 <- 2 <- 3 <- 4 <- 5
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,null)))));
        // 递归方式
        // ListNode newHead = reverseList1(head);
        // 迭代方式
        ListNode newHead = reverseList(head);
        System.out.println(head);
        System.out.println(newHead);
    }
}
