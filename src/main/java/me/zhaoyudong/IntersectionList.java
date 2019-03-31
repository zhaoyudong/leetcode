package me.zhaoyudong;

public class IntersectionList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            while (headA != null) {

                ListNode nodeb = headB;
                while (nodeb != null) {
                    if (headA.equals(nodeb)) {
                        return headA;
                    }

                    nodeb = nodeb.next;
                }

                headA = headA.next;
            }

            return null;
        }

    }
}
