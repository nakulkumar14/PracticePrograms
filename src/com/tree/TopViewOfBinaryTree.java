package com.tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by nakul on 19/10/17.
 * http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 * <p>
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
 * Given a binary tree, print the top view of it. The output nodes can be printed in any order.
 * Expected time complexity is O(n)
 */
public class TopViewOfBinaryTree {

    void printTopView(TNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        printTopViewUtil(root, 0, map);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }

    void printTopViewUtil(TNode root, int hD, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        if (map.get(hD) == null) {
            map.put(hD, root.data);
        }

        printTopViewUtil(root.left, hD - 1, map);
        printTopViewUtil(root.right, hD + 1, map);
    }


    public static void main(String[] args) {
        TNode root = TNode.createNode(1);
        root.left = TNode.createNode(2);
        root.right = TNode.createNode(3);
        root.left.left = TNode.createNode(4);
        root.left.right = TNode.createNode(5);
        root.right.left = TNode.createNode(6);
        root.right.right = TNode.createNode(7);

        System.out.println("Inorder : ");
        TNode.inorder(root);

        System.out.println("\nTop View : ");
        TopViewOfBinaryTree t = new TopViewOfBinaryTree();
        t.printTopView(root);

    }
}
