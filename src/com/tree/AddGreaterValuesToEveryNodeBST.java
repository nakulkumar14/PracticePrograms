package com.tree;

/**
 * Created by nakul on 05-Mar-17.
 *  In a BST, replace value of each node with the sum of itself and everything greater than itself.
 *  https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 */
public class AddGreaterValuesToEveryNodeBST{
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

    class Sum{
        int sum;
    }

    void addGreater(Node root,Sum sum){
        if (root!=null){
            addGreater(root.right,sum);
            sum.sum = sum.sum + root.data;
            root.data = sum.sum;
            addGreater(root.left,sum);
        }
    }

    void addgr8(Node root){
        Sum sum = new Sum();
        addGreater(root,sum);
    }

    public static void main(String[] args) {
        AddGreaterValuesToEveryNodeBST o = new AddGreaterValuesToEveryNodeBST();
        Node root = null;
//        root = o.insert(root,50);
//        root = o.insert(root,30);
//        root = o.insert(root,20);
//        root = o.insert(root,40);
//        root = o.insert(root,70);
//        root = o.insert(root,60);
//        root = o.insert(root,80);
        root = o.insert(root,5);
        root = o.insert(root,2);
        root = o.insert(root,13);
        o.inorder(root);
        System.out.println();
        o.addgr8(root);
        o.inorder(root);
        System.out.println();
    }
}
