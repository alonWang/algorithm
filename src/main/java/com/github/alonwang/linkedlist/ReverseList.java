package com.github.alonwang.linkedlist;

/**
 * @author alonwang
 * @date 2020/7/6 10:39
 * @detail 维护 待处理节点的前后节点关系.同时要注意null的位置发生了变化
 * 1 --> 2 --> 3 --> null
 * null <-- 1 <-- 2 <-- 3
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode next = head;
        ListNode prev = null;
        while (next != null) {
            ListNode cur = next;
            next = next.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }

    /**
     * 递归方式
     * 假设后面的节点已经排好了
     *
     * @param head
     * @return 新的头结点 就是原链表的最后一个元素.
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return node;
    }
}
