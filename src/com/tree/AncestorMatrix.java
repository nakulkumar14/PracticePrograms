package com.tree;

/**
 * Created by nakulkumar on 4/9/16.
 */
public class AncestorMatrix {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    Node createTree(){
        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(3);
        return  root;
    }

    int a[][]=new int[6][6];

    void buildMatrix(Node root){
        if (root==null)
            return;
        if (root.left!=null){
            a[root.data][root.left.data]=1;
        }
        if (root.right!=null){
            a[root.data][root.right.data]=1;
        }

        buildMatrix(root.left);
        buildMatrix(root.right);
    }

    void matrixPrint(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AncestorMatrix o = new AncestorMatrix();
        Node root=o.createTree();
        o.inorder(root);
        System.out.println();
        o.buildMatrix(root);

        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(o.a[i][j]==1){
                    for(int k=0;k<6;k++){
                        if(o.a[k][i]==1)
                            o.a[k][j]=1;
                    }
                }
            }
        }

        System.out.println("AM : ");
        o.matrixPrint();
    }
}
