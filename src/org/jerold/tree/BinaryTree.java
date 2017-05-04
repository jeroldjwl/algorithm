package org.jerold.tree;

import java.util.Stack;

/**
 * Created by Jerold on 2016/10/23.
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {

    }

    public BinaryTree(Node n) {
        root = n;
    }

    public boolean add(int i) {
        if (root == null) {
            Node n = new Node(i);
            root = n;
        } else {
            addNode(root, i);
        }
        return true;
    }

    private Node addNode(Node node, int i) {
        if (node == null) {
            return new Node(i);
        }
        if (i < node.v) {
            node.left = addNode(node.left, i);
        } else {
            node.right = addNode(node.right, i);
        }
        return node;
    }

    public Node getRoot() {
        return root;
    }

    public void preSearch(Node root) {
        if (root != null) {
            System.out.print(root.getV() + ", ");
            preSearch(root.getLeft());
            preSearch(root.getRight());
        }
    }

    public void preOrderNonRecursive(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                visit(p);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void midOrderNonRecursive(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                visit(p);
                p = p.right;
            }
        }
    }

    public void postOrderNonRecursive(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root, pre = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.peek();
            if (p.right == null || p.right == pre) {
                p = stack.pop();
                visit(p);
                pre = p;
                p = null;
            } else {
                p = p.right;
            }
        }
    }

    private void visit(Node p) {
        System.out.print(p.v + ", ");
    }

    public void backSearch(Node root) {
        if (root != null) {
            backSearch(root.getLeft());
            backSearch(root.getRight());
            System.out.print(root.getV() + ", ");
        }
    }

    public void midSearch(Node root) {
        if (root != null) {
            midSearch(root.getLeft());
            System.out.print(root.getV() + ", ");
            midSearch(root.getRight());
        }
    }

    class Node {
        private int v;
        private Node left;
        private Node right;

        public Node(int value) {
            this.v = value;
            this.left = null;
            this.right = null;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(3);
        bt.add(5);
        bt.add(1);
        bt.add(7);
        bt.add(6);
        System.out.println(bt.getRoot().getV());
        bt.preSearch(bt.getRoot());
        System.out.println();
        bt.preOrderNonRecursive(bt.getRoot());
        System.out.println();
        bt.midSearch(bt.getRoot());
        System.out.println();
        bt.midOrderNonRecursive(bt.getRoot());
        System.out.println();
        bt.backSearch(bt.getRoot());
        System.out.println();
        bt.postOrderNonRecursive(bt.getRoot());
    }
}
