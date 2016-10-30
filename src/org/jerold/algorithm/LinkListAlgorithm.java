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

    // 5. 逆置单链表
    public void reverse(Node header) {
        Node tmp = null, nextNode = null;
        while (header != null) {
            nextNode = header.next;
            header.setNext(tmp);
            tmp = header;
            header = nextNode;
        }
    }

    // 6. 合并两个有序链表
    public Node mergeList(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.v <= b.v) {
            result = a;
            a = a.next;
        } else {
            result = b;
            b = b.next;
        }
        while (a != null && b != null) {
            if (a.v <= b.v) {
                result.next = a;
                a = a.next;
            } else {
                result.next = b;
                b = b.next;
            }
        }
        if (a != null) {
            result.next = b;
            a = a.next;
        }
        if (b != null) {
            result.next = b;
            b = b.next;
        }
        return result;
    }

    // 不是很明白这种算法
    public Node mergeList1(Node a, Node b) {
        Node result = null;
        if (a == null) return b;
        if (b == null) return a;
        if (a.v <= b.v) {
            result = a;
            result.setNext(mergeList1(a.next, b));
        } else {
            result = b;
            result.setNext(mergeList1(b.next, a));
        }
        return result;
    }

    // 7. 逐对逆置单链表
    // 1 --> 2 --> 3 --> 4 --> NULLL
    // 2 --> 1 --> 4 --> 3 --> NULL
    public void reverseDouble(Node head) {
        Node nextNode = head;
        while (nextNode != null && nextNode.next != null) {
            Node current = nextNode;
            nextNode = nextNode.next.next;
            current.next.next = current;
            current.next = nextNode;
        }
    }

    // 8. 把循环链表分成两个单链表，如果是奇数结点，把多的那个放在第一个链表中
    public void splitList(Node head) {
        Node first;
        Node second;
        Node fast = head;
        Node slow = head;
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        second = slow.next.next;
        slow.next.next = null;
        if (fast.next == head) {
            fast.next = null;
        } else {
            fast.next.next = null;
        }
        first = head;
    }

    // 9. 给定K，逆置链表中包含K个结点的块
    //    1 --> 2 --> 3 --> 4 --> 5 --> NULL
    //k=2:2 --> 1 --> 4 --> 3 --> 5 --> NULL
    public Node reverseK(Node begin, int k) {
        if (k < 0 || begin == null)
            return null;
        Node nextKNode = nextKNode(begin, k);
        if (nextKNode != null) {
            Node tmp = reverseK(nextKNode, k);
            return reverse(begin, k, tmp);
        } else {
            return reverse(begin, k, null);
        }
    }

    private Node reverse(Node node, int k, Node pointTo) {
        if (node == null)
            return null;
        Node current = node;
        Node tmp = pointTo;
        Node nextNode;
        for (int i = 0; i < k; i++) {
            nextNode = current.next;
            current.next = tmp;
            tmp = current;
            if (nextNode == null)
                break;
            current = nextNode;
        }
        return tmp;
    }

    private Node nextKNode(Node begin, int k) {
        if (begin == null)
            return null;
        Node current = begin;
        for (int i = 0; i < k; i++) {
            if (current == null) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    // 10. 约瑟夫环问题 N个人中选领导，每隔M个移除一人，求最后剩下的那个。
    private Node joseph(Node head, int m) {
        if (head == null)
            return null;
        Node current = head;
        while (current.next != current) {
            for (int i = 0; i < m - 1; i++) {
                current = current.next;
            }
            Node tmp = current.next;
            current.next = current.next.next;
            tmp = null;
        }
        return current;
    }

    public Node joseph(int n, int m) {
        Node head, tail;
        head = new Node(1);
        tail = head;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            tail.next = node;
            tail = node;
        }
        tail.next = head;
        // return joseph(head, m);
        for (int count = n; count > 1; count--) {
            for (int i = 0; i < m - 1; i++) {
                head = head.next;
            }
            head.next = head.next.next;
        }
        System.out.println(head.v);
        return head;
    }

    public static void main(String[] args) {
        LinkListAlgorithm lla = new LinkListAlgorithm();
        Node n = lla.joseph(41, 3);
        System.out.println(n.v);

    }

    // 11. copy link
    public Node copy(Node head) {
        Node X, Y;
        X = head;
        Map map = new HashMap();
        while (X != null) {
            Y = new Node(X.v);
            Y.next = null;
            map.put(X, Y);
        }
        X = head;
        while (X != null) {
            Y = (Node) map.get(X);
            Y.setNext((Node) map.get(X.next));
        }
        return (Node) map.get(head);
    }

    private class Node {
        int v;
        Node next;

        Node(int i) {
            this.v = i;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
