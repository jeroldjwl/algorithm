package org.jerold.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jerold on 2017/4/30.
 */
public class Question2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        while (l1 != null) {
            queue1.offer(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            queue2.offer(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        ListNode ret = null;
        ListNode root = null;
        while (queue1.size() > 0 && queue2.size() > 0) {
            int n1 = queue1.poll();
            int n2 = queue2.poll();
            int tmp = n1 + n2;
            if (flag == 1) {
                tmp = tmp + 1;
                flag = 0;
            }
            if (tmp >= 10) {
                flag = 1;
                tmp = tmp - 10;
            }
            ListNode node = new ListNode(tmp);
            if (ret == null) {
                ret = node;
                root = node;
            } else {
                ret.next = node;
                ret = ret.next;
            }
        }
        while (queue1.size() > 0 && ret != null) {
            ListNode node = null;
            int tmp = queue1.poll();
            if (flag == 1) {
                if (tmp == 9) {
                    tmp = 0;
                    flag = 1;
                } else {
                    tmp++;
                    flag = 0;
                }
            }
            node = new ListNode(tmp);
            ret.next = node;
            ret = ret.next;
        }
        while (queue2.size() > 0 && ret != null) {
            ListNode node = null;
            int tmp = queue2.poll();
            if (flag == 1) {
                if (tmp == 9) {
                    tmp = 0;
                    flag = 1;
                } else {
                    tmp++;
                    flag = 0;
                }
            }
            node = new ListNode(tmp);
            ret.next = node;
            ret = ret.next;
        }
        if (flag == 1 && ret != null) {
            ret.next = new ListNode(1);
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        /*ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(3);
        ListNode l15 = new ListNode(3);*/
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        /*ListNode l23 = new ListNode(4);
        ListNode l24 = new ListNode(1);*/
        /*l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;*/
        l21.next = l22;
        /*l22.next = l23;
        l23.next = l24;*/
        addTwoNumbers(l11, l21);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
