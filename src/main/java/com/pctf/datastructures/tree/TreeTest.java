package com.pctf.datastructures.tree;

public class TreeTest {
    public static void main (String[] args) {
        BinaryTree<Integer> bTree = new BinaryTree<>();
//        for (int i = 0; i < 15; i++) {
//            bTree.insert(i);
//        }
        bTree.insert(7);
        bTree.insert(4);
        bTree.insert(13);
        bTree.insert(2);
        bTree.insert(6);
        bTree.insert(11);
        bTree.insert(15);
        bTree.insert(1);
        bTree.insert(3);
        bTree.insert(5);
        bTree.insert(10);
        bTree.insert(12);
        System.out.println("tree's height is " + bTree.height());
        System.out.println("tree's min is " + bTree.findMin());
        bTree.printTree();
        System.out.println("tree" + (bTree.contains(18) ? "contains" : "doesn't" ) + "contains 18");
        System.out.println("tree" + (bTree.contains(14) ? "contains" : "doesn't" ) + "contains 14");
        bTree.remove(14);
        System.out.println("tree" + (bTree.contains(14) ? "contains" : "doesn't" ) + "contains 14");

    }
}
