package com.ifocus.preps.misc;

class ListNode {
    int val = 0;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        ListNode current = head; // current node that we will be processing
        ListNode previous = null; // previous node that we have processed
        ListNode next = null; // will be used to temporarily store the next node

        while (current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            // before we move to the next node, point previous to the current node
            previous = current;
            current = next; // move on the next node
        }
        // after the loop current will be pointing to 'null' and 'previous' will be the
        // new head
        return previous;
    }

    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = sol.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

