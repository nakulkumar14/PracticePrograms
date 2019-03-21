package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class DiagonalTraversal extends TNode {

    public static void diagnoalPrint(TNode root) {
        Queue<TNode> queue = new ArrayDeque<>();
        TNode temp = root;
        while (temp != null) {
            queue.add(temp);
            temp = temp.right;
        }

        while (!queue.isEmpty()) {
            TNode node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
                TNode curr = node.left;
                while (curr != null) {
                    queue.add(curr);
                    curr = curr.right;
                }
            }
        }

    }

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.left.left = new TNode(11);
        root.left.left.right = new TNode(12);
        root.left.left.right.right = new TNode(13);
        root.left.left.right.right.right = new TNode(14);
        root.left.left.right.right.right.left = new TNode(15);
        root.left.left.right.right.right.left.right = new TNode(16);
        root.right = new TNode(3);
        root.left.right = new TNode(5);
        root.right.right = new TNode(4);
        root.right.right.right = new TNode(8);
        root.right.right.right.left = new TNode(9);
        root.right.right.right.left.right = new TNode(10);
        root.right.left = new TNode(6);
        root.right.left.right = new TNode(7);

        TNode.levelOrderTraversal(root);
        System.out.println();
        diagnoalPrint(root);
    }
}
