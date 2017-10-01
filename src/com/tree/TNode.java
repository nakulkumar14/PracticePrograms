package com.tree;

/**
 * Created by nakul on 26-Nov-16.
 */
public class TNode {
    int data;
    TNode left,right;
    TNode nextRight;

    public TNode() {
    }

    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static TNode createNode(int data){
        return new TNode(data);
    }

    public static TNode insertToBST(TNode root, int data){
        if (root == null){
            root = new TNode(data);
        }else if (root.data > data){
            root.left = insertToBST(root.left, data);
        }else{
            root.right = insertToBST(root.right, data);
        }
        return root;
    }

    public static void inorder(TNode root){
        if (root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static void preorder(TNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
