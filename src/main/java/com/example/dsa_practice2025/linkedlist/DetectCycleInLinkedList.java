package com.example.dsa_practice2025.linkedlist;

public class DetectCycleInLinkedList
{
    /**
     * 141. Linked List Cycle
     * @param args
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
        System.out.println(hasCycle(head));
    }

    // youtube link - https://www.youtube.com/watch?v=-1E8ZMS0gSs

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
