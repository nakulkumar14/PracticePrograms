package com.tree;

/**
 * Created by nakulkumar on 1/8/16.
 */
public class CheckBST {
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

    boolean isBST(Node root, Node prev) {
        if (root == null) {
            return true;
        }

        if (!isBST(root.left, prev))
            return false;

        if (prev != null && prev.data >= root.data)
            return false;

        prev = root;
        return isBST(root.right, prev);

    }

    int height(Node root){
        if (root==null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);

        if (l>r)
            return l+1;
        return r+1;
    }

    static int index=0;

    void kthLargest(Node root,int k){
        if (root==null)
            return;
        kthLargest(root.right,k);

        if(++index==k){
            System.out.println("Kth largest : "+root.data);
            return;
        }

        kthLargest(root.left,k);

    }

    public static void main(String[] args) {
        CheckBST o = new CheckBST();
        Node root = null;
        root = o.insert(root, 12);
        root = o.insert(root, 15);
        o.inorder(root);
        System.out.println();
        root = o.insert(root, 14);
        root = o.insert(root, 8);
        o.inorder(root);
        System.out.println();
        root = o.insert(root, 10);
        root = o.insert(root, 5);
        o.inorder(root);
        System.out.println();
        System.out.println(o.isBST(root, null));

        o.kthLargest(root,1);

        System.out.println("Height : "+o.height(root));

        root = null;
        root = o.insert(root, 12);
        root = o.insert(root, 15);
        root = o.insert(root, 17);
        root = o.insert(root, 19);
        o.inorder(root);
        System.out.println(o.isBST(root, null));
    }
}
