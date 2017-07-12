package com.tree;

import java.util.Stack;

/**
 * Created by nakul on 12/7/17.
 */
public class PostorderIterative {

    static void postorderIterative(TNode root){
        if (root == null)
            return;

        Stack<TNode> s1 = new Stack<>();
        Stack<TNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.empty()){
            TNode temp = s1.pop();
            s2.push(temp);

            if (temp.left!=null)
                s1.push(temp.left);
            if (temp.right!=null)
                s1.push(temp.right);
        }

        while (!s2.empty()){
            TNode temp = s2.pop();
            System.out.print(temp.data+" ");
        }
    }

    public static void main(String[] args) {
        TNode root = null;
        root = TNode.insertToBST(root,4);
        root = TNode.insertToBST(root,6);
        root = TNode.insertToBST(root,2);
        root = TNode.insertToBST(root,3);

        TNode.inorder(root);

        System.out.println("\nPostorder : ");
        postorderIterative(root);
    }
}
