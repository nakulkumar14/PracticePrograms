package com.tree;

/**
 * Created by nakul on 16/9/17.
 */
public class CheckIfSiblings {

    static boolean isSibling(TNode root,int x,int y){
        if (root==null)
            return false;

        if (root.left!=null && root.right!=null && root.left.data==x && root.right.data==y)
            return true;

        return isSibling(root.left,x,y) || isSibling(root.right,x,y);
    }

    public static void main(String[] args) {
        TNode root = null;
        System.out.println("Inorder : ");
        root = TNode.insertToBST(root,5);
        root = TNode.insertToBST(root,3);
        root = TNode.insertToBST(root,7);
        root = TNode.insertToBST(root,2);
        root = TNode.insertToBST(root,4);
        root = TNode.insertToBST(root,6);
        root = TNode.insertToBST(root,8);
        TNode.inorder(root);

        System.out.println();
        System.out.println("IsSibling : "+isSibling(root,6,8));
        System.out.println("IsSibling : "+isSibling(root,6,7));
    }
}
