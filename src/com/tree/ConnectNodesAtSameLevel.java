package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by nakul on 24/9/17.
 * Write a function to connect all the adjacent nodes at the same level in a binary tree. Structure of the given Binary Tree node is like following.
 * struct Node{
 * int data;
 * Node* left;
 * Node* right;
 * Node* nextRight;
 * }
 */

public class ConnectNodesAtSameLevel {

    static void connect(TNode root) {

        if (root == null)
            return;

        Queue<TNode> queue = new ArrayDeque<>();

        queue.add(root);
        queue.add(new TNode(Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            TNode node = queue.remove();

            if (Integer.MAX_VALUE == node.data) {
                if (queue.peek() != null)
                    queue.add(new TNode(Integer.MAX_VALUE));
            }

            if (node != null && !queue.isEmpty()) {
                node.nextRight = queue.peek().data!=Integer.MAX_VALUE?queue.peek():null;
            }
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        System.out.println();
        printSpecial(root);
    }

    static void printSpecial(TNode root) {
        if (root == null)
            return;
        TNode node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextRight;
        }
        if (root.left != null)
            printSpecial(root.left);
        else
            printSpecial(root.right);

    }

    public static void main(String[] args) {
        TNode root = null;
        root = TNode.insertToBST(root, 5);
        root = TNode.insertToBST(root, 3);
        root = TNode.insertToBST(root, 7);
        root = TNode.insertToBST(root, 2);
        root = TNode.insertToBST(root, 4);
        root = TNode.insertToBST(root, 6);
        root = TNode.insertToBST(root, 8);


        System.out.println("\nInorder : ");
        TNode.inorder(root);

        System.out.println("\nPreorder : ");
        TNode.preorder(root);
        connect(root);
    }
}
