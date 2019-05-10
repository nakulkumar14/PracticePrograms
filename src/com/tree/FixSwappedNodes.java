package com.tree;

// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
public class FixSwappedNodes {

    static TNode prev, first, second;

    static void swappedBST(TNode node) {
        if (node == null)
            return;
        prev = null;
        first = null;
        second = null;
        swappedUtil(node);
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    static void swappedUtil(TNode node) {
        if (node == null)
            return;
        swappedUtil(node.left);
        if (prev != null && prev.data > node.data) {
            if (first == null) {
                first = prev;
            } else {
                second = node;
            }
        }
        prev = node;
        swappedUtil(node.right);
    }

    public static void main(String[] args) {
        TNode root = new TNode(10);
        root.left = new TNode(5);
        root.right = new TNode(8);
        root.left.left = new TNode(2);
        root.left.right = new TNode(20);
        TNode.inorder(root);
        System.out.println();
        swappedBST(root);
        System.out.println();
        TNode.inorder(root);

        root = null;

        root = new TNode(6);
        root.left = new TNode(10);
        root.right = new TNode(2);
        root.left.left = new TNode(1);
        root.left.right = new TNode(3);
        root.right.right = new TNode(12);
        root.right.left = new TNode(7);

        System.out.println();
        TNode.inorder(root);
        System.out.println();
        swappedBST(root);
        System.out.println();
        TNode.inorder(root);


    }
}
