package com.practice;

import java.util.Stack;

/**
 * Created by nakulkumar on 31/7/16.
 * <p/>
 * Given a preorder traversal create BST from it.
 */
public class BSTFromPreorder {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node createBST(int a[]) {
        Stack<Node> s = new Stack<>();
        Node root = new Node(a[0]);
        s.push(root);

        for (int i = 1; i < a.length; i++) {
            Node temp = null;

            while (!s.isEmpty() && a[i] > s.peek().data) {
                temp = s.pop();
            }
            if (temp != null) {
                temp.right = new Node(a[i]);
                s.push(temp.right);
            } else {
                temp = s.peek();
                temp.left = new Node(a[i]);
                s.push(temp.left);
            }
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        BSTFromPreorder b = new BSTFromPreorder();

        // Preorder array.
        int a[] = {10, 5, 1, 7, 40, 50};
        Util.showArray(a);
        Node root = b.createBST(a);
        b.inorder(root);
    }
}
