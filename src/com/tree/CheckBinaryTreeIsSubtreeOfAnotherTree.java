package com.tree;

/**
 * Created by nakul on 01-Oct-17.
 * Given two binary trees, check if the first tree is subtree of the second one.
 * A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T.
 */
public class CheckBinaryTreeIsSubtreeOfAnotherTree {

    // Utility method.
    static boolean areIdentical(TNode T, TNode S) {
        if (T == null && S == null)
            return true;

        if (T == null || S == null)
            return false;

        return (T.data == S.data && areIdentical(T.left, S.left) && areIdentical(T.right, S.right));
    }

    // Method to check if S is subtree of T.
    static boolean isSubTree(TNode T, TNode S) {
        if (T == null && S == null)
            return true;

        if (T == null || S == null)
            return false;

        //check for left and right subtree if current nodes are same.
        if (T.data == S.data && isSubTree(T.left, S.left) && isSubTree(T.right, S.right))
            return true;

        return isSubTree(T.left, S) || isSubTree(T.right, S);
    }

    static void storeInorder(TNode root, StringBuilder s) {
        if (root != null) {
            storeInorder(root.left, s);
            s.append(root.data + ",");
            storeInorder(root.right, s);
        }
    }

    static void storePreOrder(TNode root, StringBuilder s) {
        if (root != null) {
            s.append(root.data + ",");
            storePreOrder(root.left, s);
            storePreOrder(root.right, s);
        }
    }

    static boolean checkSubTree(StringBuilder t, StringBuilder s) {
        return t.toString().contains(s.toString());
    }

    public static void main(String[] args) {

        TNode tNode = null;
        tNode = TNode.createNode(5);
        tNode.left = TNode.createNode(15);
        tNode.right = TNode.createNode(7);
        tNode.left.right = TNode.createNode(2);

        System.out.println("T : ");
        TNode.inorder(tNode);
        System.out.println();

        TNode sNode = null;
        sNode = TNode.createNode(6);
        sNode.left = TNode.createNode(5);
        sNode.right = TNode.createNode(4);
        sNode.right.left = TNode.createNode(2);
        sNode.right.right = TNode.createNode(1);
        sNode.left.left = TNode.createNode(15);
        sNode.left.left.right = TNode.createNode(2);
        sNode.left.right = TNode.createNode(7);

        System.out.print("S : ");
        TNode.inorder(sNode);

        System.out.println(isSubTree(sNode, tNode));

        // find the inorder string for the tree.
        StringBuilder inS = new StringBuilder();
        storeInorder(sNode, inS);
        inS.setLength(inS.length() - 1);
//        System.out.println(inS);

        // find the inorder string for the tree.
        StringBuilder inT = new StringBuilder();
        storeInorder(tNode, inT);
        inT.setLength(inT.length() - 1);
//        System.out.println(inT);

        // find the preorder string for the tree.
        StringBuilder preS = new StringBuilder();
        storePreOrder(sNode, preS);
        preS.setLength(preS.length() - 1);
//        System.out.println(preS);

        // find the preorder string for the tree.
        StringBuilder preT = new StringBuilder();
        storePreOrder(tNode, preT);
        preT.setLength(preT.length() - 1);
//        System.out.println(preT);

        // check if inorder string is substring of another inorder string, if so
        // check if preorder string is substring of another preorder string.
        boolean res = checkSubTree(inS, inT) ? checkSubTree(preS, preT) : false;
        System.out.println("Result : " + res);
    }
}
