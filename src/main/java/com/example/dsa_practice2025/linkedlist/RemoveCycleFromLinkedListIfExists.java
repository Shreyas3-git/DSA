package com.example.dsa_practice2025.linkedlist;

public class RemoveCycleFromLinkedListIfExists
{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = head.next.next.next;
        detectCycle(head);
        traverse(head);
    }

    public static void detectCycle(ListNode head) {
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
            return;
        }
        slow = head;
        ListNode prev = null;
        while(slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
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
