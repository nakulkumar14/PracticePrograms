package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public static void preorder(TNode root){
        if (root!=null){
            System.out.print(root.data+" ");
            inorder(root.left);
            inorder(root.right);
        }
    }

    public static void levelOrderTraversal(TNode root) {
        Queue<TNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
