package com.tree;

class BSTNode{
    int data;
    BSTNode left, right, parent;
    BSTNode(int data){
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
}

public class InorderSuccessor {

    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
            root.left.parent = root;
        } else {
            root.right = insert(root.right, data);
            root.right.parent = root;
        }
        return root;
    }

    int successor(BSTNode root){
        if (root==null)
            return -1;

        if (root.right!=null){
            BSTNode min = root.right;
            while (min.left!=null){
                min = min.left;
            }
            return min.data;
        }else{
                BSTNode p = root;
                while (p.parent!=null && p!=p.parent.left){
                    p = p.parent;
                }
                return p.parent!=null?p.parent.data:-1;
        }

    }

    public static void main(String[] args) {
        InorderSuccessor o = new InorderSuccessor();
        BSTNode node = o.insert(null, 50);
        node = o.insert(node, 20);
        node = o.insert(node, 60);
        node = o.insert(node, 40);
        node = o.insert(node, 10);
        node = o.insert(node, 5);
        node = o.insert(node, 15);

        o.inorder(node);
        System.out.println("\nsuccessor : " +node.data + ","+o.successor(node));
        System.out.println("\nsuccessor : " +node.left.data+ ","+ o.successor(node.left));
        System.out.println("\nsuccessor : " +node.right.data+ ","+ o.successor(node.right));
        System.out.println("\nsuccessor : " +node.left.left.data+ ","+ o.successor(node.left.left));
        System.out.println("\nsuccessor : " +node.left.left.left.data+ ","+ o.successor(node.left.left.left));

        System.out.println("\nsuccessor : " +node.left.right.data+ ","+ o.successor(node.left.right));
        System.out.println("\nsuccessor : " +node.left.left.right.data+ ","+ o.successor(node.left.left.right));
    }
}
