package com.tree;

import java.util.Stack;

/**
 * Created by nakul on 12/7/17.
 */
public class PostorderIterative {

    // using 2 stacks
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

    static void postOrderSingleStack(TNode root){
        if (root == null)
            return;

        Stack<TNode> s = new Stack<>();

        while (!s.isEmpty() || root != null)
        {
            // push right then root, go to left as much as possible
            while (root != null)
            {
                if (root.right != null)
                    s.add(root.right);
                s.add(root);
                root = root.left;
            }

            root = s.pop();

            // use root's right and repeat above process
            if (root.right != null && !s.isEmpty()
                    && root.right == s.peek())
            {
                TNode rootRight = s.pop();
                s.push(root);
                root = rootRight;
            } else
            {
                System.out.print(root.data + " ");
                root = null;
            }
        }

    }

    public static void main(String[] args) {
        TNode root = null;
        root = TNode.insertToBST(root,4);
        root = TNode.insertToBST(root,6);
        root = TNode.insertToBST(root,2);
        root = TNode.insertToBST(root,3);

        System.out.println("Inorder : ");
        TNode.inorder(root);

        System.out.println("\nPostorder - 2 ss : ");
        postorderIterative(root);

        root = null;
        root = TNode.insertToBST(root,5);
        root = TNode.insertToBST(root,3);
        root = TNode.insertToBST(root,7);
        root = TNode.insertToBST(root,2);
        root = TNode.insertToBST(root,4);
        root = TNode.insertToBST(root,6);
        root = TNode.insertToBST(root,8);


        System.out.println("\nInorder : ");
        TNode.inorder(root);

        System.out.println("\nPostorder - 1 s : ");
        postOrderSingleStack(root);
    }
}
