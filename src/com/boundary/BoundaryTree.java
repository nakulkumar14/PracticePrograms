package com.boundary;

/**
 * Created by nakul on 10-Sep-16.
 */


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.right = this.left = null;
    }
}

public class BoundaryTree {

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void printBoundary(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printLeftBoundary(root.left);

            // print leaves
            printLeaves(root.left);
            printLeaves(root.right);

            printRightBoundary(root.right);
        }
    }

    private void printRightBoundary(Node root) {
        if (root!=null){
            if (root.left!=null){
                printRightBoundary(root.left);
                System.out.print(root.data+" ");
            }else if (root.right!=null){
                printRightBoundary(root.right);
                System.out.print(root.data+" ");
            }
        }
    }

    private void printLeftBoundary(Node root) {
        if (root != null) {
            if (root.left != null) {
                System.out.print(root.data + " ");
                printLeftBoundary(root.left);
            } else if (root.right != null) {
                System.out.print(root.data + " ");
                printLeftBoundary(root.right);
            }
        }
    }

    private void printLeaves(Node root) {
        if (root!=null){
            printLeaves(root.left);
            if (root.left==null && root.right==null)
                System.out.print(root.data+" ");
            printLeaves(root.right);
        }
    }

    public static void main(String[] args) {
        BoundaryTree tree = new BoundaryTree();
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        System.out.println("Inorder : ");
        tree.inorder(root);
        System.out.println("\nBoundary : ");
        tree.printBoundary(root);
    }
}
