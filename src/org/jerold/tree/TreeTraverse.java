package org.jerold.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Jerold on 2018/7/8.
 */
public class TreeTraverse {


    private static void wildFirstTraverseNoRecursive(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                break;
            }
            System.out.print(node.name + ", ");
            List<TreeNode> children = node.children;
            if (children != null) {
                queue.addAll(children);
            }
        }
    }

    private static void deepFirstTraverseNoRecursive(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            List<TreeNode> children = node.children;
            if (children != null) {
                
            }
        }
    }

    private static void deepFirstTraverseWithRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.name + ", ");
        if (root.children != null) {
            for (TreeNode node : root.children) {
                deepFirstTraverseWithRecursive(node);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("root", null);
        TreeNode first = new TreeNode("first", null);
        TreeNode second = new TreeNode("second", null);
        TreeNode three = new TreeNode("three", null);
        TreeNode flFirst = new TreeNode("flFirst", null);
        TreeNode slFirst = new TreeNode("slFirst", null);
        TreeNode flSecond = new TreeNode("flSecond", null);
        List<TreeNode> flSecondChildren = new ArrayList<>();
        flSecondChildren.add(flSecond);
        second.children = flSecondChildren;
        List<TreeNode> slFirstChildren = new ArrayList<>();
        slFirstChildren.add(slFirst);
        slFirst.children = slFirstChildren;
        List<TreeNode> firstChildren = new ArrayList<>();
        firstChildren.add(flFirst);
        first.children = firstChildren;
        List<TreeNode> rootChildren = new ArrayList<>();
        rootChildren.add(first);
        rootChildren.add(second);
        rootChildren.add(three);
        root.children = rootChildren;
        wildFirstTraverseNoRecursive(root);
        System.out.println();
        deepFirstTraverseWithRecursive(root);
    }

    private static class TreeNode {
        private String name;
        private List<TreeNode> children;

        TreeNode(String name, List<TreeNode> children) {
            this.name = name;
            this.children = children;
        }
    }
}


