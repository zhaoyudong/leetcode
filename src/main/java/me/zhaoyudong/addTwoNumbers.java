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

        ListNode result = null;
        ListNode resultHead = null;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + tmp;
            tmp = val / 10;
            val = val % 10;

            l1 = l1.next;
            l2 = l2.next;

            if(result==null){
                result = new ListNode(val);
                resultHead = result;
            }else {
                result.next = new ListNode(val);
                result = result.next;
            }
        }

        ListNode remain = l1 == null ? l2 : l1;

        while (remain != null) {
            int val = remain.val + tmp;
            tmp = val / 10;
            val = val % 10;

            remain = remain.next;

            if(result==null){
                result = new ListNode(val);
                resultHead = result;
            }else {
                result.next = new ListNode(val);
                result = result.next;
            }
        }

        if (tmp != 0) {
            result.next = new ListNode(tmp);
        }

        return resultHead;
    }

    public static void main(String[] args) {

    }
}
