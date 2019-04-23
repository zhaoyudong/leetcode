package me.zhaoyudong;

import java.util.Arrays;
import java.util.Comparator;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode nodeHead = null;
        ListNode node = null;

        for (; ; ) {
            Arrays.sort(lists, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1 == null && o2 == null) {
                        return 0;
                    }
                    if (o1 == null) {
                        return 1;
                    }
                    if (o2 == null) {
                        return -1;
                    }
                    return Integer.compare(o1.val, o2.val);
                }
            });

            if (lists[0] == null) {
                break;
            }

            if (node == null) {
                node = lists[0];
                nodeHead = node;
            } else {
                node.next = lists[0];
                node = node.next;
            }
            lists[0] = lists[0].next;
            node.next = null;
        }
        return nodeHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
