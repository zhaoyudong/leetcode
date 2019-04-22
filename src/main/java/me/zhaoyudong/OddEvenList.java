package me.zhaoyudong;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode j = head;
        ListNode o = head.next;
        ListNode ohead = o;
        while (j.next != null && o.next != null) {
            j.next = o.next;
            j = j.next;

            o.next = j.next;
            o = o.next;
        }
        j.next = ohead;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
