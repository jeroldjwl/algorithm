package org.jerold.list;

import org.jerold.tree.BinaryTree;

/**
 * Created by Jerold on 2016/10/23.
 */
public class Test {
    public static void main(String[] args) {
        /*SingleLinkList list = new SingleLinkList();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.print();
        System.out.println();
        list.printFromTail();*/
        BinaryTree bt = new BinaryTree();
        bt.add(10);
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(14);
        bt.add(12);
        bt.add(16);
        bt.preSearch(bt.getRoot());
        System.out.println();
        bt.midSearch(bt.getRoot());
        System.out.println();
        bt.backSearch(bt.getRoot());
    }
}
