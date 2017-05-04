package org.jerold.tree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Jerold on 2017/4/9.
 */
public class NewBinaryTree {
    private Node root;

    private class Node {
        private int v;
        private Node left;
        private Node right;

        public Node(int v) {
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }

    // recursive version
    public boolean add(int i) {
        if (root != null) {
            add(root, i);
        } else {
            Node n = new Node(i);
            root = n;
        }
        return true;
    }

    private Node add(Node root, int i) {
        if (root == null) {
            Node n = new Node(i);
            return n;
        }
        if (i < root.v) {
            root.left = add(root.left, i);
        } else {
            root.right = add(root.right, i);
        }
        return root;
    }

    public boolean get(int i) {
        if (root == null)
            throw new NoSuchElementException();
        Node n = search(root, i);
        return n != null;
    }

    private Node search(Node root, int i) {
        if (root == null)
            return null;
        if (i == root.v)
            return root;
        if (i < root.v)
            return search(root.left, i);
        else return search(root.right, i);
    }

    // recursive version
    public void preSearch(Node n) {
        if (n != null) {
            System.out.println(n.v + ",");
            preSearch(n.left);
            preSearch(n.right);
        }
    }

    public void midSearch(Node n) {
        if (n != null) {
            midSearch(n.left);
            System.out.println(n.v + ",");
            midSearch(n.right);
        }
    }

    public void backSearch(Node n) {
        if (n != null) {
            backSearch(n.left);
            backSearch(n.right);
            System.out.print(n.v + ",");
        }
    }

    // non-recursive version
    public void preSearchNoneRecursive(Node n) {
        Stack<Node> stack = new Stack<>();
        Node p = n;
        if (p != null) {
            stack.push(p);
            while (!stack.empty()) {
                Node node = stack.pop();
                System.out.print(node.v + ",");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
    }

    public void preSearchNoneRecursive2(Node n) {
        Stack<Node> stack = new Stack<>();
        Node p = n;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                System.out.print(p.v + ",");
                stack.push(p);
                p = p.left;
            }
            while (stack.size() > 0) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void midSearchNoneRecursive(Node n) {
        Stack<Node> stack = new Stack<>();
        Node p = n;
        while (p != null) {
            while (p != null) {
                if (p.right != null) {
                    stack.push(p.right);
                }
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            while (!stack.empty() && p.right == null) {
                System.out.print(p.v + ",");
                p = stack.pop();
            }
            System.out.print(p.v + ",");
            if (!stack.empty())
                p = stack.pop();
            else p = null;
        }
    }

    public void backSearchNoneRecursive(Node n) {
        Stack<Node> stack = new Stack<>();
        Node p = n;
        while (p != null) {
            stack.push(p);
            if (p.right != null)
                stack.push(p.right);

        }
    }
}
