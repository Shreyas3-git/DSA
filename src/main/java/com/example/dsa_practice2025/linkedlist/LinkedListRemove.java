package com.example.dsa_practice2025.linkedlist;

public class LinkedListRemove
{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode node = linkedListRemove(6,head);
        traverse(node);
    }


    public static ListNode linkedListRemove(int x,ListNode head) {
        /**
         *   algorithm:
         *   1)check head == null
         *      return;
         *   2)declare dummy node with -1
         *   3)assign head to dummy's next
         *   4)declare current init dummy
         *   5)iterate till current and current.next not null
         *      1]check current.next.val == x
         *          current.next = current.next.next
         *     2]otherwise
         *          current = current.next
         *   6)end loop
         */
        if(head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while(current != null && current.next != null) {
            if(current.next.val == x) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }


    public static void traverse(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
