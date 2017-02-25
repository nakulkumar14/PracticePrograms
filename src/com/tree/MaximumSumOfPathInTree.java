package com.tree;

/**
 * Created by nakul on 18-Feb-17.
 * Maximum triangle path Sum : Starting from the top of a pyramid of numbers,
 * you can walk down going one step on the right or on the left,
 * until you reach the bottom row.
 *
 */
public class MaximumSumOfPathInTree {

    static void inorder(TNode root){
        if (root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static int msum = 0 ;

    static void maxSumUtil(TNode root,int sum){
        if (root==null)
            return;
        sum+=root.data;
        if (msum<sum)
            msum = sum;
        maxSumUtil(root.left,sum);
        maxSumUtil(root.right,sum);
    }

    static void maxSum(TNode root){
        if (root==null)
            return;
        maxSumUtil(root,0);
        System.out.println("Max sum : "+msum);
    }

    public static void main(String[] args) {
        TNode root = new TNode(55);
        root.left = new TNode(94);
        root.left.left = new TNode(95);
        root.left.left.left = new TNode(77);
        root.left.left.right = new TNode(71);
        root.left.right = new TNode(30);
        root.left.right.right = new TNode(26);

        root.right = new TNode(48);
        root.right.right = new TNode(96);
        root.right.right.right = new TNode(67);

        System.out.println("Tree : ");
        inorder(root);
        maxSum(root);

    }
}
