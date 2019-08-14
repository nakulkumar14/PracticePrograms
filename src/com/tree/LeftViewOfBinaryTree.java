package com.tree;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/iterative-method-to-print-left-view-of-a-binary-tree/
public class LeftViewOfBinaryTree {

    static int m = 0;

    static void leftView(TNode root) {
        leftView(root, 1);
    }

    static void leftView(TNode root, int level) {
        if (root == null)
            return;

        if (m < level) {
            System.out.print(root.data + " ");
            m = level;
        }

        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    static void leftViewIterative(TNode root) {
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TNode node = queue.peek();
            if (node != null) {

                System.out.print(node.data + " ");

                while (queue.peek() != null) {
                    TNode temp = ((LinkedList<TNode>) queue).pop();
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }

            } else {
                ((LinkedList<TNode>) queue).pop();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
    }

    public static void main(String[] args) {
        TNode root = TNode.createNode(1);
        root.left = TNode.createNode(2);
        root.right = TNode.createNode(3);
        root.left.left = TNode.createNode(4);
        root.right.left = TNode.createNode(5);
        root.right.left.left = TNode.createNode(6);

        System.out.println("Inorder : ");
        TNode.inorder(root);
        System.out.println();
        System.out.println();
        leftView(root);
        System.out.println();
        leftViewIterative(root);
    }
}
