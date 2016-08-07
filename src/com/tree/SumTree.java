package com.tree;

/**
 * Created by nakulkumar on 7/8/16.
 */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class SumTree {

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    int sum(Node root) {
        if (root == null)
            return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    boolean isSumTree(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        int ls = sum(root.left);
        int rs = sum(root.right);

        if ((root.data == ls + rs) && isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    boolean sumTreeEfficient(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int ls = 0, rs = 0;
        if (sumTreeEfficient(root.left) && sumTreeEfficient(root.left)) {
            if (root.left == null)
                ls = 0;
            else if (isLeaf(root.left)) {
                ls = root.left.data;
            } else {
                ls = 2 * root.left.data;
            }

            if (root.right == null)
                rs = 0;
            else if (isLeaf(root.right)) {
                rs = root.right.data;
            } else {
                rs = 2 * root.right.data;
            }

            if (root.data == ls + rs)
                return true;

            return false;
        }

        return false;
    }

    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        SumTree sumTree = new SumTree();
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        sumTree.inorder(root);
        System.out.println();
        long start, end;

        start = System.nanoTime();
        System.out.println("Is sum tree ? : " + sumTree.isSumTree(root));
        end = System.nanoTime();
        System.out.println("time : " + (end - start));
        
        start = System.nanoTime();
        System.out.println("Is sum tree ? : " + sumTree.sumTreeEfficient(root));
        end = System.nanoTime();
        System.out.println("time : " + (end - start));


    }
}
