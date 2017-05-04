package org.jerold.tree;

import java.util.Stack;

/**
 * Created by Jerold on 2017/4/23.
 */
public class BinarySearchTree {
    private Node root;

    public boolean add(int v) {
        if (root != null)
            add(root, v);
        else root = add(root, v);
        return true;
    }

    private Node add(Node root, int v) {
        if (root == null) {
            Node node = new Node(v, null, null);
            return node;
        }
        if (v < root.v)
            root.left = add(root.left, v);
        else root.right = add(root.right, v);
        return root;
    }

    public void preOrderSearch(Node p) {
        if (p != null) {
            System.out.print(p.v + ", ");
            preOrderSearch(p.left);
            preOrderSearch(p.right);
        }
    }

    public void preOrderNonrecursive(Node p) {
        Node pos = p;
        Stack stack = new Stack();
        while (pos != null || stack.size() > 0) {
            while (pos != null) {
                System.out.print(pos.v + ", ");
                stack.push(pos);
                pos = pos.left;
            }
            if (stack.size() > 0) {
                pos = (Node) stack.pop();
                pos = pos.right;
            }
        }
    }

    public void midOrderSearch(Node p) {
        if (p != null) {
            midOrderSearch(p.left);
            System.out.print(p.v + ", ");
            midOrderSearch(p.right);
        }
    }

    public void midOrderNonrecursive(Node p) {
        Node pos = p;
        Stack stack = new Stack();
        while (pos != null || stack.size() > 0) {
            while (pos != null) {
                stack.push(pos);
                pos = pos.left;
            }
            if (stack.size() > 0) {
                pos = (Node) stack.pop();
                System.out.print(pos.v + ", ");
                pos = pos.right;
            }
        }
    }

    public void backOrderSearch(Node p) {
        if (p != null) {
            backOrderSearch(p.left);
            backOrderSearch(p.right);
            System.out.print(p.v + ", ");
        }
    }

    public void backOrderNonrecursive(Node p) {
        Node pos = p, pre = p;
        Stack stack = new Stack();
        while (pos != null || stack.size() > 0) {
            while (pos != null) {
                stack.push(pos);
                pos = pos.left;
            }
            pos = (Node) stack.peek();
            if (pos.right == null || pos.right == pre) {
                pos = (Node) stack.pop();
                System.out.print(pos.v + ", ");
                pre = pos;
                pos = null;
            } else {
                pos = pos.right;
            }
        }
    }

    private class Node {
        private int v;
        private Node left;
        private Node right;

        public Node(int v, Node left, Node right) {
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.add(3);
        bt.add(5);
        bt.add(1);
        bt.add(7);
        bt.add(6);
        System.out.println(bt.root.v);
        bt.preOrderSearch(bt.root);
        System.out.println();
        bt.preOrderNonrecursive(bt.root);
        System.out.println();
        bt.midOrderSearch(bt.root);
        System.out.println();
        bt.midOrderNonrecursive(bt.root);
        System.out.println();
        bt.backOrderSearch(bt.root);
        System.out.println();
        bt.backOrderNonrecursive(bt.root);
    }
}
