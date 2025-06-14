package com.example.dsa_practice2025.linkedlist;

public class DetectCycleLinkedList_II
{
    /**
     * 142. Linked List Cycle II
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = head.next.next.next;
        ListNode node = detectCycle(head);
        traverse(node);
    }

    public static ListNode detectCycle(ListNode head) {
        /**
         *  algorithm :
         *  1)declare slow,fast pointer with head
         *  declare boolean isCyle
         *  2)iterate till fast != null and fast.next != null to avoid even length and odd length LL null pointer exception
         *  3)move slow by 1 node
         *  4)move fast by2 nodes
         *  5)check slow == fast
         *      isCyle = true
         *      break;
         *  6)end loop
         *  7)check isCyle == false
         *      return null
         *  8)declare slow = head
         *  9)iterate slow != fast
         *      move slow by 1
         *      move fast by 1
         *  10)end loop
         *  11)return slow
         *
         *
         */
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void traverse(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val+"->");
            current = current.next;
        }
        System.out.print("NULL");
    }
}
