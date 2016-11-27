package com.tree;

/**
 * Created by nakul on 27-Nov-16.
 */
public class LCA extends TNode{

    public static void inorder(TNode root){
        if (root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static TNode lca(TNode root,int v1,int v2){
        if (root==null)
            return null;

        if (root.data == v1 || root.data == v2)
            return root;

        TNode l = lca(root.left,v1,v2);
        TNode r = lca(root.right,v1,v2);

        if (l!=null && r!=null)
            return root;

        return (l!=null)?l:r;
    }

    public static void main(String[] args) {
        TNode root = null;
        root = createNode(10);
        root.left = createNode(5);
        root.left.left = createNode(2);
        root.left.right= createNode(8);
        root.right = createNode(17);
        root.right.left = createNode(15);

        inorder(root);

        TNode res = lca(root,12,20);

        if (res!=null)
        System.out.println("\nLCA : "+res.data);
        else
            System.out.println("NULL");
    }
}
