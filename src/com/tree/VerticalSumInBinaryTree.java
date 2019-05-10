package com.tree;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
public class VerticalSumInBinaryTree {

    static void verticalSum(TNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        verticalSumUtil(root, map, 0);

        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void verticalSumUtil(TNode root, Map<Integer, Integer> map, int dis) {
        if (root != null) {
            verticalSumUtil(root.left, map, dis - 1);

            if (map.containsKey(dis)) {
                map.put(dis, map.get(dis) + root.data);
            } else {
                map.put(dis, root.data);
            }

            verticalSumUtil(root.right, map, dis + 1);
        }
    }

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);

        verticalSum(root);
    }
}
