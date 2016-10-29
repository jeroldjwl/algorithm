package org.jerold.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerold on 2016/10/29.
 */
public class LinkListAlgorithm {

    // 1. 已知链表，找到链表的倒数第N个结点
    public int findMethod1(Node header, int n) {
        if (header != null || n >= 0) {
            Node current = header;
            int length = 0;
            while (current != null) {
                length++;
                current = current.next;
            }
            if (length < n) {
                throw new IllegalArgumentException("no such element");
            }
            int position = length - n + 1;
            Node target = header;
            for (int i = 0; i < position; i++) {
                target = target.next;
            }
            return target.v;
        } else {
            throw new IllegalArgumentException("link list is empty");
        }
    }

    public int findMethod2(Node header, int n) {
        if (header != null) {
            Node second = header;
            Node first = header;
            for (int i = 0; i < n; i++) {
                if (second != null) {
                    second = second.next;
                } else {
                    throw new IllegalArgumentException("no such element");
                }
            }
            while (second.next != null) {
                second = second.next;
                first = first.next;
            }
            return first.v;
        } else {
            throw new IllegalArgumentException("link list is empty");
        }
    }

    // 2. 判断给定链表是NULL结尾还是形成一个环

    public boolean isCircle(Node header) {
        if (header == null) {
            return false;
        }
        boolean isCircle = false;
        Node fast = header;
        Node slow = header;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCircle = true;
                break;
            }
        }
        return isCircle;
    }

    // 3. 判断给定链表是否有环，如果有的话，找出那个结点
    //    思路1：用一个map存储Node地址和Node
    //    思路2：在相遇点断开，让问题演变为找两个链表的第一个公共点
    // ori: 1 --> 3 --> 4 --> 5 --> 6
    //                  |           |
    //                  | <-- 7 <-- |
    //  l1: 1 --> 3 --> 4 --> 5
    //  l2: 6 --> 7 --> 4 --> 5
    public int getCircleNode(Node header) {
        boolean isCircle = isCircle(header);
        if (isCircle) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            Node current = header;
            int i = 0;
            while (map.get(current.hashCode()) == null) {
                current = current.next;
                i++;
                map.put(current.hashCode(), i);
            }
            return (int) map.get(current.hashCode());
        } else {
            System.out.println("no circle in link");
            return -1;
        }
    }

    // 4. 给定两个链表，判断两个链表是否有公共结点

    public boolean hasSameNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1 == node2) {
            return true;
        }
        int len1 = 0;
        int len2 = 0;
        boolean hasSameNode = false;
        Node current = node1;
        while (current != null) {
            len1++;
            current = current.next;
        }
        current = node2;
        while (current != null) {
            len2++;
            current = current.next;
        }
        int diff;
        Node longer;
        Node shorter;
        if (len1 > len2) {
            diff = len1 - len2;
            longer = node1;
            shorter = node2;
        } else {
            diff = len2 - len1;
            longer = node2;
            shorter = node1;
        }
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                hasSameNode = true;
                break;
            } else {
                longer = longer.next;
                shorter = shorter.next;
            }
        }
        return hasSameNode;
    }

    private class Node {
        int v;
        Node next;

        Node(int i) {
            this.v = i;
            this.next = null;
        }
    }

}
