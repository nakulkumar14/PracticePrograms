package com.tree;

public class CountLeaves {

    static int count(TNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return count(node.left) + count(node.right);
    }

    public static void main(String[] args) {
        TNode tree = new TNode(1);
        tree.left = new TNode(2);
        tree.right = new TNode(3);
        tree.left.left = new TNode(4);
        tree.left.right = new TNode(5);
        System.out.println(count(tree));
    }
}
