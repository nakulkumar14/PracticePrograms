package com.tree;

/**
 * Created by nakulkumar on 1/8/16.
 */
public class CheckBST {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
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

    boolean isBST(Node root, Node prev) {
        if (root == null) {
            return true;
        }

        if (!isBST(root.left, prev))
            return false;

        if (prev != null && prev.data >= root.data)
            return false;

        prev = root;
        return isBST(root.right, prev);

    }

    public static void main(String[] args) {
        CheckBST o = new CheckBST();
        Node root = null;
        root = o.insert(root, 12);
        root = o.insert(root, 15);
        o.inorder(root);
        System.out.println();
        root = o.insert(root, 14);
        root = o.insert(root, 8);
        o.inorder(root);
        System.out.println();
        root = o.insert(root, 10);
        root = o.insert(root, 5);
        o.inorder(root);
        System.out.println();
        System.out.println(o.isBST(root, null));
    }
}
