package org.jerold.tree;

/**
 * Created by jerold on 2016/10/26.
 */
public class TreeConstructor {
    public TreeConstructor() {

    }

    public void construct(int[] preOrder, int[] midOrder) {

    }

    private class TreeNode {
        private int v;
        private TreeNode left;
        private TreeNode right;

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
