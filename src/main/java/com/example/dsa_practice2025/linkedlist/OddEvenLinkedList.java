package com.example.dsa_practice2025.linkedlist;

public class OddEvenLinkedList
{
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        head = oddEvenList(head);
        traverse(head);
    }

    public static ListNode oddEvenList(ListNode head) {
        /**
         *   e.g -
         *   2->1->3->5->6->4->7->NULL
         *   return odd index node then even index node
         *   2->3->6->7->
         *   1->5->4
         *   result -
         *   2->3->6->7->1->5->4-NULL
         */
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
