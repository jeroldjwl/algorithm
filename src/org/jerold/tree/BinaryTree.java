package org.jerold.tree;

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

    private void addNode(Node root, int i) {
        if (i < root.getV()) {
            if (root.getLeft() != null) {
                addNode(root.getLeft(), i);
            } else {
                Node n = new Node(i);
                root.setLeft(n);
            }
        } else {
            if (root.getRight() != null) {
                addNode(root.getRight(), i);
            } else {
                Node n = new Node(i);
                root.setRight(n);
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void preSearch(Node root) {
        if (root != null) {
            System.out.print(root.getV() + ", ");
            if (root.getLeft() != null) {
                preSearch(root.getLeft());
            }
            if (root.getRight() != null) {
                preSearch(root.getRight());
            }
        }
    }

    public void preSearchNoRecursive(Node root) {
        if (root != null) {
            Node tmp = root;
            while (tmp.getLeft() != null || tmp.getRight() != null) {
                System.out.println(tmp.getV() + ", ");
                if (tmp.getLeft() != null) {
                    tmp = tmp.getLeft();
                    continue;
                }
                if (tmp.getRight() != null) {
                    tmp = tmp.getRight();
                    continue;
                }
            }
        }
    }

    public void backSearch(Node root) {
        if (root != null) {
            if (root.getLeft() != null) {
                if (root.getLeft().getLeft() != null || root.getLeft().getRight() != null) {
                    backSearch(root.getLeft());
                } else {
                    System.out.print(root.getLeft().getV() + ", ");
                }
            }
            if (root.getRight() != null) {
                if (root.getRight().getRight() != null || root.getRight().getLeft() != null) {
                    backSearch(root.getRight());
                } else {
                    System.out.print(root.getRight().getV() + ", ");
                }
            }
            System.out.print(root.getV() + ", ");
        }
    }

    public void midSearch(Node root) {
        if (root != null) {
            if (root.getLeft() != null) {
                midSearch(root.getLeft());
            }
            System.out.print(root.getV() + ", ");
            if (root.getRight() != null) {
                midSearch(root.getRight());
            }
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
}
