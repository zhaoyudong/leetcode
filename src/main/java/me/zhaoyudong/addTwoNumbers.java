package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int tmp = 0;

        List<ListNode> nodes = new ArrayList<>();

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + tmp;
            tmp = val / 10;
            val = val % 10;

            l1 = l1.next;
            l2 = l2.next;

            nodes.add(new ListNode(val));
        }

        ListNode remain = l1 == null ? l2 : l1;

        while (remain != null) {
            int val = remain.val + tmp;
            tmp = val / 10;
            val = val % 10;

            remain = remain.next;

            nodes.add(new ListNode(val));
        }

        if (tmp != 0) {
            nodes.add(new ListNode(tmp));
        }

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        return nodes.get(0);
    }

    public static void main(String[] args) {

    }
}
